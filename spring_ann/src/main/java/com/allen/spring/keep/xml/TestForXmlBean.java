package com.allen.spring.keep.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author allen
 * @descript 测试类
 * @date 2020-03-21 6:05 PM
 */
public class TestForXmlBean {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Object person = applicationContext.getBean("person");
        System.out.println(person);
    }
}
