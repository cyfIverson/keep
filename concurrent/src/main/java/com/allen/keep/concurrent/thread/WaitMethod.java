package com.allen.keep.concurrent.thread;

/**
 * @descript Obj的wait()方法 与notify()一起使用
 * @author cyfIverson
 * @date 2019-07-14 11:24 PM
 */
public class WaitMethod extends Thread{

    private String name;
    private Object prev;
    private Object self;

    public WaitMethod(String name,Object prev,Object self){
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 面试题：建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC
     */
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        WaitMethod pa = new WaitMethod("A", c, a);
        WaitMethod pb = new WaitMethod("B", a, b);
        WaitMethod pc = new WaitMethod("C", b, c);


        new Thread(pa).start();
        //确保按顺序A、B、C执行
        Thread.sleep(100);
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }

}
