package com.allen.jdk8.learn;

/**
 * 定义个函数式接口
 */
@FunctionalInterface
interface myFunctionInterface{

    void test();

    @Override
    String toString();
}

/**
 * @descript 自定义函数式接口自己实现个lambda表达式
 * @author cyfIverson
 * @date 2019-07-18 3:14 PM
 */
public class CreateFunction {

    void createFunctionTest(myFunctionInterface myFunctionInterface){

        System.out.println(1);
        myFunctionInterface.test();
        System.out.println(2);

    }

    public static void main(String[] args) {
        CreateFunction createFunction = new CreateFunction();

        createFunction.createFunctionTest(new myFunctionInterface() {
            @Override
            public void test() {
                System.out.println("createFunctionTest");
            }
        });

        createFunction.createFunctionTest(()->{
            System.out.println("createFunctionTest");
        });
    }
}

