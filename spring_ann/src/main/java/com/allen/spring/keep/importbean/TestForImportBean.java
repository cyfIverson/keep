package com.allen.spring.keep.importbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author allen
 * @descript 测试类
 * @date 2020-03-21 8:00 PM
 */
public class TestForImportBean {

    public static void main(String[] args) throws Exception {
       ApplicationContext app = new AnnotationConfigApplicationContext(BeanConfig.class);

        System.out.println("IOC容器创建完成------");

        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Object object = app.getBean("allenFactoryBean");
        System.out.println(object);
    }
}
