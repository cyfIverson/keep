package com.allen.keep.concurrent.thread;

/**
 * @descript 创建线程的方式二：实现Runnable接口，重写run()方法
 * @author cyfIverson
 * @date 2019-07-14 1:41 PM
 */
public class Thread2 implements Runnable{

    private String name;

    public Thread2(String name){
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(name + "在运行"+ i);

            try {
                //随机睡眠几秒时间，便于看演示结果
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new Thread2("C")).start();
        new Thread(new Thread2("D")).start();

        Thread thread2 = new Thread(new Thread2("heihei"));
        thread2.start();

        thread2.stop();
        thread2.suspend();
        thread2.resume();

        thread2.interrupt();
        thread2.isInterrupted();
        Thread.interrupted();
    }
}
