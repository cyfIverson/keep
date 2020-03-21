package com.allen.spring.keep.scan;

import com.allen.spring.keep.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author allen
 * @descript bean的配置
 * @date 2020-03-21 6:15 PM
 */
@Configuration
@ComponentScan(value = "com.allen.spring.keep.scan")
public class BeanConfig {

    /**
     * 给容器中注册一个Bean
     */
    @Bean(name = "allen")
    public Person person(){
        return new Person(20,"allen");
    }
}
