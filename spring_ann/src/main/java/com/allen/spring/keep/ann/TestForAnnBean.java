package com.allen.spring.keep.ann;

import com.allen.spring.keep.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author allen
 * @descript 注解测试bean类
 * @date 2020-03-21 6:16 PM
 */
public class TestForAnnBean {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Object person = applicationContext.getBean("allen");
        System.out.println(person);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
