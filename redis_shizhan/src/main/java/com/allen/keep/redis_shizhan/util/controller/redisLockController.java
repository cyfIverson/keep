package com.allen.keep.redis_shizhan.util.controller;

import com.allen.keep.redis_shizhan.util.lock.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author allen
 * @descript
 * @date 2020-03-16 9:02 AM
 */
@RestController
@RequestMapping("redisLock")
public class redisLockController {


    @Autowired
    private RedisLock redisLock;

    @RequestMapping("/test")
    public String redisLock(){
        redisLock.lock();
        System.out.println("加锁成功，去解锁");
        redisLock.unlock();
        System.out.println("解锁成功");
        return "请求成功";
    }
}
