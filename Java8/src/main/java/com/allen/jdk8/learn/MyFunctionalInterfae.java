package com.allen.jdk8.learn;

/**
 * @descript 定义一个自己的函数式接口
 * @author cyfIverson
 * @date 2019-07-18 2:58 PM
 */
@FunctionalInterface
public interface MyFunctionalInterfae {

    void test();

    @Override
    String toString();
}
