package com.allen.keep.concurrent.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author allen
 * @descript 只有main函数的线程
 * @date 2020-03-16 10:52 AM
 */
public class OnlyMain {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(+threadInfo.getThreadId() + "-" + threadInfo.getThreadName());
        }
    }
}
