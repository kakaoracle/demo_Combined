package com.ali.多线程.第二章_互斥;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-07-15 13:17
 **/
public class LockTwo implements Lock {

    private volatile int victim;

    @Override
    public void lock() {
        int i  = (int) Thread.currentThread().getId();
        victim = i;
        while (victim == i){

        }
    }

    @Override
    public void unlock() {

    }
}
