package com.allen.keep.concurrent.thread.syn;

/**
 * @descript synchronized关键字用法总结
 * @author cyfIverson
 * @date 2019-07-14 11:44 PM
 */
public class SynchronizedWord {

    public static void main(String[] args) {
        /**
         * Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：
         * 1、普通同步方法（实例方法），锁是当前实例对象 ，进入同步代码前要获得当前实例的锁
         * 2、静态同步方法，锁是当前类的class对象 ，进入同步代码前要获得当前类对象的锁
         * 3、同步方法块，锁是括号里面的对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁
         */

        // 修饰实例方法
        Thread threadForInstance1 = new Thread(new SynchronizedUseForInstance());
        Thread threadForInstance2 = new Thread(new SynchronizedUseForInstance());

        threadForInstance1.start();
        threadForInstance2.start();
    }
}
