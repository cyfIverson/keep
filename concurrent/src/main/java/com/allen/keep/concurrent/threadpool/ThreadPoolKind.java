package com.allen.keep.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @descript 线程池种类
 * @author cyfIverson
 * @date 2019-07-16 12:05 AM
 */
public class ThreadPoolKind {

    /**
     * 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
     *  的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明:Executors 返回的线程池对象的弊端如下:
     *
     *  1)FixedThreadPool 和 SingleThreadPool:允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
     *  2)CachedThreadPool 和 ScheduledThreadPool: 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM
     **/
    public static void main(String[] args) {

        //创建一个固定长度的线程池，当到达线程最大数量时，线程池的规模将不再变化
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        //创建一个可缓存的线程池，如果当前线程池的规模超出了处理需求，将回收空的线程；当需求增加时，会增加线程数量；线程池规模无限制。
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //创建一个单线程
        ExecutorService singleThreadPoll = Executors.newSingleThreadExecutor();

        //创建一个固定长度的线程池，而且以延迟或者定时的方式来执行【效果类似定时器】
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);


        /**
         * 各线程池的实际运用场景介绍
         */
        /** FixedThreadPool */

        for (int i = 1; i < 5; i++) {
            final int taskID = i;
            fixedThreadPool.execute(new Runnable() {
//            cachedThreadPool.execute(new Runnable(){
//            singleThreadPoll.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j < 5; j++) {
                        try {
                            Thread.sleep(20); // 为了测试出效果，让每次任务执行都需要一定时间
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("第" + taskID + "次任务的第" + j + "次执行");
                    }
                }
            });
        }
    }
}
