package com.iss.Utils.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 多线程工具类
 * @author: cWX597167
 * @create: 2019-03-31 17:25
 **/
public class ThreadUtils {
    /*
    同时开启sum个线程用来做高并发测试
     */
    public static void beginThreads(int sum){
        final CountDownLatch countDownLatch = new CountDownLatch(sum);
        Thread[] threads= new Thread[sum];
        for (int i = 0;i<sum;i++){
            Thread thread = new Thread(()->{
                try {
                    //所有线程都在等待,当countDownLatch 为0时,代表所有线程都同时start
                    countDownLatch.await();
                    //这里是要执行的具体方法
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i] = thread;
            thread.start();
            //每就绪一个线程,就减一
            countDownLatch.countDown();
        }
    }
}




































