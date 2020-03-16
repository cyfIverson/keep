package com.allen.keep.redis_shizhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.allen.keep.redis_shizhan.*")
public class RedisShizhanApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisShizhanApplication.class, args);
    }

}
