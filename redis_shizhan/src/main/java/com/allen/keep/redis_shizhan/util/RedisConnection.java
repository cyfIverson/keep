package com.allen.keep.redis_shizhan.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * @author allen
 * @descript redis代码连接
 * @date 2020-03-14 10:20 AM
 */
public class RedisConnection {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String allen = jedis.get("name");

        SetParams setParams = new SetParams();
        setParams.nx();
        setParams.px(10000);
        String set = jedis.set("name1", "allen", setParams);
        System.out.println(set);
        System.out.println(allen);
    }
}
