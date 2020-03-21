package com.allen.spring.keep.importbean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author allen
 * @descript
 * @date 2020-03-21 8:36 PM
 */
public class AllenFactoryBean implements FactoryBean<Monkey> {

    @Override
    public Monkey getObject(){
        return new Monkey();
    }

    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
