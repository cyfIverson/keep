package com.allen.spring.keep.ann;

import com.allen.spring.keep.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author allen
 * @descript bean的配置
 * @date 2020-03-21 6:15 PM
 */
@Configuration
public class BeanConfig {

    /**
     * 给容器中注册一个Bean
     */
    @Bean(name = "allen")
    @Scope
    public Person person(){
        return new Person(20,"allen");
    }
}