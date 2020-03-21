package com.allen.keep.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author allen
 * @descript 实现Callable接口，允许有返回值
 * @date 2020-03-16 11:04 AM
 */
public class Thread3 implements Callable {

    private String name;

    public Thread3(String name){
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
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

        return "callResult";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread3 thread3 = new Thread3("E");
        FutureTask futureTask = new FutureTask<>(thread3);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
