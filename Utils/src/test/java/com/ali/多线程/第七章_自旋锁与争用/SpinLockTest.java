package com.ali.多线程.第七章_自旋锁与争用;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 自旋锁
 * @author: DeZhao Chen
 * @create: 2019-07-24 16:02
 **/
public class SpinLockTest {

    public class sample{
        ThreadLocal<Long> threadId = new ThreadLocal<>();
        Long threadIdJustLong;

        public Long getThreadIdJustLong() {
            return threadIdJustLong;
        }

        public void setThreadIdJustLong(Long threadIdJustLong) {
            this.threadIdJustLong = threadIdJustLong;
        }
    }



    @Test
    public void testThreadLocal(){
        sample sample = new sample();
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    //countDownLatch
                    countDownLatch.await();
                    sample.threadId.set(Thread.currentThread().getId());
                    //sample.setThreadIdJustLong(Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i] = thread;
            thread.start();
            //每就绪一个线程,就减一
            countDownLatch.countDown();
        }
        /*System.out.println("+++++threadLocal: "+sample.threadId.get());
        System.out.println("+++++Long: "+sample.getThreadIdJustLong());*/
    }

    @Test
    public void testLong(){
        String a = null;
        String b;
        String c = new String();
    }


}
