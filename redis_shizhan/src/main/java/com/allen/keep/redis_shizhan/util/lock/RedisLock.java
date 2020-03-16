package com.allen.keep.redis_shizhan.util.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author allen
 * @descript redis实现分布式锁
 * @date 2020-03-16 12:18 AM
 */
@Service
public class RedisLock implements Lock {

    /** jedis连接池 */
    @Autowired
    private JedisPool jedisPool;

    /** 定义一个key */
    private static final String KEY = "redisLockTest";

    private ThreadLocal<String> threadLocal = new ThreadLocal();

    @Override
    public void lock() {
        // 1、尝试加锁
        if (tryLock()){
            return;
        }

        // 2、加锁失败，当前任务休眠一段时间
        try {
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 3、递归调用，再次重新加锁
        lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /** 非阻塞锁 */
    @Override
    public boolean tryLock() {

        // 产生随机字符串
        String uuid = UUID.randomUUID().toString();

        // 获取redis 客户端
        Jedis jedis = jedisPool.getResource();
        // 使用setnx命令请求写值，并设置失效时间
        SetParams setParams = new SetParams();
        setParams.nx();
        setParams.px(10000);
        String set = jedis.set(KEY, uuid, setParams);
        jedis.close();
        // 用线程本地变量来存值，用于后面线程使用,此值用于后面解锁做比较，保证谁加的锁谁解，不能A加的锁B去解锁
        threadLocal.set(uuid);
        if ("OK".equals(set)){
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * 解锁
     */
    @Override
    public void unlock() {
        // 通过lua脚本，来保证原子性
        String luaStr = "if redis.call(\"get\",KEYS[1]) == ARGV[1]then return redis.call(\"del\",KEYS[1]) else return 0 end";
        // 获取jedis
        Jedis jedis = jedisPool.getResource();
        jedis.close();
        // 通过连接执行lua脚本
        jedis.eval(luaStr,2,KEY,threadLocal.get());
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
