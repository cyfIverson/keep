package com.allen.keep.redis_shizhan.util.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author allen
 * @descript 模拟并发情况下卖火车的实例（出现线程不安全的例子）
 * @date 2020-03-15 1:02 PM
 */
public class TicketTest {

    /** 总共100张火车票 */
    // 实例变量，现在共享是非线程安全的   (类变量和实例量在jvm的堆里面)
    private static int ticketCount = 100;

    // juc包的原子 Integer类型
//    private static AtomicInteger ticketCount = new AtomicInteger(100);

    private  static  Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        TicketRunnable ticketRunnable = new TicketRunnable();

        // 多个线程对应的多个接口
        Thread thread1 = new Thread(ticketRunnable, "窗口A");
        Thread thread2 = new Thread(ticketRunnable, "窗口B");
        Thread thread3 = new Thread(ticketRunnable, "窗口C");
        Thread thread4 = new Thread(ticketRunnable, "窗口D");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.currentThread().join();
    }

    public static  class TicketRunnable  implements Runnable{

        @Override
        public void run() {
//            while (ticketCount >0){
//                if (ticketCount > 0){
//                    System.out.println(Thread.currentThread().getName()+"售票第"+(ticketCount--)+"张票");
//                }
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            //线程不全的解决方案一，加synchronized
//            while (ticketCount >0){
//                synchronized (TicketTest.class){
//                    if (ticketCount > 0){
//                        System.out.println(Thread.currentThread().getName()+"售票第"+(ticketCount--)+"张票");
//                    }
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

            // 线程不全的解决方案二 因为是原子操作，将变量使用原子Integer变量
//            while (ticketCount.intValue() > 0){
//                if (ticketCount.intValue() > 0){
//                    System.out.println(Thread.currentThread().getName()+"售票第"+(ticketCount.getAndDecrement())+"张票");
//                }
//            }

            //线程不安全的解决方案三。加锁 lock
            while (ticketCount > 0){
                lock.lock();
                try{
                    if (ticketCount >0 ){
                        System.out.println(Thread.currentThread().getName()+"售票第"+(ticketCount--)+"张票");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    // 解锁很关键，必须要执行，避免死锁发生
                    lock.unlock();
                }

            }
        }
    }
}
