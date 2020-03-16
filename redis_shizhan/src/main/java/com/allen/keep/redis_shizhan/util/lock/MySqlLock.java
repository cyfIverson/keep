//package com.allen.keep.redis_shizhan.util.lock;
//
//import com.allen.keep.redis_shizhan.util.mapper.LockMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//
///**
// * @author allen
// * @descript 基于MySql的分布式锁的实现
// * @date 2020-03-15 10:15 PM
// */
//@Service
//public class MySqlLock implements Lock {
//
//    private static final int ID_NUM = 1;
//
//    @Autowired
//    private LockMapper lockMapper;
//
//    /**
//     * 阻塞式加锁
//     */
//    @Override
//    public void lock() {
//        // 1、尝试加锁
//        if (tryLock()){
//            return;
//        }
//
//        // 2、加锁失败，当前任务休眠一段时间
//        try {
//            Thread.sleep(10);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        // 3、递归调用，再次重新加锁
//        lock();
//    }
//
//    @Override
//    public void lockInterruptibly() throws InterruptedException {
//
//    }
//
//    /**
//     * 非阻塞的加锁，往数据库写入一条ID为1的数据，能写入成功的就代表加锁成功
//     * @return 成功 返回true  失败：返回false
//     */
//    @Override
//    public boolean tryLock() {
//        try {
//            lockMapper.insert(ID_NUM);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//    @Override
//    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
//        return false;
//    }
//
//    /**
//     * 解锁
//     */
//    @Override
//    public void unlock() {
//        lockMapper.delet(ID_NUM);
//    }
//
//    @Override
//    public Condition newCondition() {
//        return null;
//    }
//}
