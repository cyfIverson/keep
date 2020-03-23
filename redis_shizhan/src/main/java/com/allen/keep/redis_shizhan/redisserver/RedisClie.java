package com.allen.keep.redis_shizhan.redisserver;

import redis.clients.jedis.Jedis;

/**
 * @author allen
 * @descript
 * @date 2020-03-23 11:40 AM
 */
public class RedisClie {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6380);
        String set = jedis.set("allen", "3");
        jedis.close();
    }
}
