package com.allen.jvm.learn;

/**
 * @descript 类加载学习的例子
 * @author cyfIverson
 * @date 2019-07-27 3:01 PM
 */
public class ClassLoadForLearn {

    public static void main(String[] args) {
        System.out.println(Children.string);
    }
}

class Parent{

    public static String string = "I am parent";

    static {
        System.out.println("parent static block!");
    }
}

class Children extends Parent{

    public static String string = "I am Children";

    static {
        System.out.println("children static block!");
    }
}