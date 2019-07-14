package com.allen.keep.concurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * concurrent包启动类
 * @author allen
 */
@RestController
@SpringBootApplication
public class ConcurrentApplication {

    @RequestMapping("/")
    public String index(){
        return "hello concurrent";
    }

    public static void main(String[] args) {
        SpringApplication.run(ConcurrentApplication.class, args);
    }

}
