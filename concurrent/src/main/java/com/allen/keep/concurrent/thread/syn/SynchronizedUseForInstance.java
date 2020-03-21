package com.allen.keep.concurrent.thread.syn;

/**
 * @author allen
 * @descript synchronized使用作用在实例方法上
 * @date 2020-03-17 10:21 AM
 */
public class SynchronizedUseForInstance implements Runnable{

    static int a = 1;

    /**
     * synchronized修饰实例方法
     */
    public synchronized void increase(){
        a++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 1、普通同步方法（实例方法），锁是当前实例对象 ，进入同步代码前要获得当前实例的锁
        SynchronizedUseForInstance synchronizedUseForInstance = new SynchronizedUseForInstance();
        Thread threadForInstance1 = new Thread(synchronizedUseForInstance);
        Thread threadForInstance2 = new Thread(synchronizedUseForInstance);

        threadForInstance1.start();
        threadForInstance2.start();

        threadForInstance1.join();
        threadForInstance2.join();
    }
}
