package com.allen.spring.keep.importbean;

import com.allen.spring.keep.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author allen
 * @descript bean配置
 * @date 2020-03-21 7:59 PM
 */
@Configuration
@Import(value = {Dog.class,Cat.class,AllenImportSelector.class,AllenImportBeanDefinitionRegistrar.class})
public class BeanConfig {

    @Bean
    public Person person(){
        return new Person();
    }

    @Bean("allenFactoryBean")
    public AllenFactoryBean allenFactoryBean(){
        return new AllenFactoryBean();
    }
}
