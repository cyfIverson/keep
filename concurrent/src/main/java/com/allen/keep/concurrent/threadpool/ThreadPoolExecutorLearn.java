package com.allen.keep.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @descript Java线程池的实现类的学习
 * @author cyfIverson
 * @date 2019-07-16 12:44 AM
 */
public class ThreadPoolExecutorLearn {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
