package com.allen.jdk8.learn;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @descript jdk8 stream测试
 * @author cyfIverson
 * @date 2019-07-18 2:01 PM
 */
public class StreamTestOne {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);

        integerList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("--------------");

        integerList.forEach(integer -> System.out.println(integer));

    }
}