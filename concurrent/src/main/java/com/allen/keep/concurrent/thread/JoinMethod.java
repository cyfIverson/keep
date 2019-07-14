package com.allen.keep.concurrent.thread;

/**
 * @descript 线程的join()方法使用
 * @author cyfIverson
 * @date 2019-07-14 10:34 PM
 */
public class JoinMethod {

    /**
     * ****** 说明 线程加入：join()方法，等待其他线程终止。在当前线程中调用另一个线程的join()方法，
     *      * 则当前线程转入阻塞状态，直到另一个进程运行结束，当前线程再由阻塞转为就绪状态。
     *      *
     *      * 使用方式：join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。
     *      * 也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行
     * ******
     */
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"主线程开始运行！");

        Thread1 thread1 = new Thread1("A");
        Thread1 thread2 = new Thread1("B");

        thread1.start();
        thread2.start();

        /** 加上下面的thread1、thread2、调用join()方法，主线程必须等该线程执行完才会结束 */
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"主线程结束运行！");
    }
}
