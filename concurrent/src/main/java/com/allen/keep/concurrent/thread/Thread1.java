package com.allen.keep.concurrent.thread;


/**
 * @descript 创建线程的方式一：继承Thread类
 * @author cyfIverson
 * @date 2019-07-14 1:41 PM
 */
public class Thread1 extends Thread{

    private String name;

    public Thread1(String name){
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"线程开始运行");

        for (int i = 0; i < 5; i++) {
            System.out.println(name + "在运行"+ i);

            try {
                //随机睡眠几秒时间，便于看演示结果
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"线程结束运行");

    }

    public static void main(String[] args) {
        /**
         * 看运行结果，有时候是B在运行0在A在运行0前面，思考，为什么我先调用的
         * 线程A的start（）方法，为什么会出现这样结果？
         */
        new Thread1("A").start();
        new Thread1("B").start();
    }
}
