package com.allen.spring.keep.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author allen
 * @descript 测试类
 * @date 2020-03-21 6:33 PM
 */
public class TestForScanBean {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(BeanConfig.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
