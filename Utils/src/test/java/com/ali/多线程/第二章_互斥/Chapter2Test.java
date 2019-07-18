package com.ali.多线程.第二章_互斥;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-07-15 10:22
 **/
public class Chapter2Test {
    @Test
    public void 测试布尔数组的默认值(){
        boolean[] flag = new boolean[2];
        System.out.println(flag[0]+","+flag[1]);
    }

    private Long privateId = 0L;
    public Long publicId = 1L;
    @Test
    public void 测试各成员变量是否是线程共享() {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    //
                    countDownLatch.await();
                    privateId = Thread.currentThread().getId();
                    publicId = Thread.currentThread().getId();
                    System.out.println("+++++privateId: " + privateId+",publicId: "+publicId+" ,当前线程id: "+Thread.currentThread().getId());
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
