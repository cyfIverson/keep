package com.allen.keep.concurrent.thread;

/**
 * @descript 关于ThreadLocal的学习理解
 * @author cyfIverson
 * @date 2019-07-15 12:26 PM
 */
public class ThreadLocalLearn {

    /**
     * 详解见网易云笔记：http://note.youdao.com/noteshare?id=4732b1e087f6fc298a5e6802d383e57c
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("cyfIverson");
        String name = local.get();
        System.out.println(name);
    }
}
