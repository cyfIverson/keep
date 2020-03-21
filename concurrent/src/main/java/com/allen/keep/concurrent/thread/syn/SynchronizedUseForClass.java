package com.allen.keep.concurrent.thread.syn;

/**
 * @author allen
 * @descript synchronized使用作用在类方法
 * @date 2020-03-17 10:21 AM
 */
public class SynchronizedUseForClass implements Runnable{

    static int a = 1;

    /**
     * synchronized修饰实例方法
     */
    public synchronized static void increase(){
        a++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 2、静态同步方法，锁是当前类的class对象 ，进入同步代码前要获得当前类对象的锁
        Thread threadForInstance1 = new Thread(new SynchronizedUseForClass());
        Thread threadForInstance2 = new Thread(new SynchronizedUseForClass());

        threadForInstance1.start();
        threadForInstance2.start();

        threadForInstance1.join();
        threadForInstance2.join();

        System.out.println(a);
    }
}
