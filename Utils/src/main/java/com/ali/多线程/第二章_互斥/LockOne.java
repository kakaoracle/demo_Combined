package com.ali.多线程.第二章_互斥;

/**
 * @description: LockOne算法,假设只有两个线程,id分别为0和1
 * @author: DeZhao Chen
 * @create: 2019-07-15 11:15
 **/
public class LockOne implements Lock {
    private boolean[] flag = new boolean[2];

    //0线程lock,为true,1线程
    @Override
    public void lock() {
        int A = (int) Thread.currentThread().getId();
        int B = 1 - A;
        flag[A] = true;
        while (flag[B]){

        }
    }

    @Override
    public void unlock() {
        int A  = (int) Thread.currentThread().getId();
        flag[A] = false;
    }
}
