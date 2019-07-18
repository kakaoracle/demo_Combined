package com.ali.多线程.第二章_互斥;

/**
 * @description: Peterson锁, 是最简单最完美的双线程互斥算法
 * @author: DeZhao Chen
 * 前提: 只有两个线程,且id分别为0与1
 * 关键点1: 找到临界区,即非原子操作语句,即既包含读操作,也包含写操作,也是while一句
 * @create: 2019-07-17 14:57
 **/
public class LockThree {
    private volatile boolean[] flag = new boolean[2];
    private volatile int victim;
    //线程0先:
    //      无干扰:i=0,j=1,[true,false],victim=0;线程0正常获取锁
    //      临界区前干扰:干扰前,i=0,j=1,[true,false],victim=0;干扰后,i,j不变(方法栈),[true,true],victim=1,线程0正常获取锁
    //线程1先:
    //      无干扰:i=1,j=0,[false,true],victim=1;线程1正常获取锁
    //      临界区前干扰:干扰前,i=1,j=0,[false,true],victim=1;干扰后,i,j不变,[true,false],victim=0,线程1正常获取锁
    public void lock(){
        int i = (int) Thread.currentThread().getId();
        int j = 1-i;
        flag[i] = true;
        victim = i;
        while (flag[j] && victim == i){
            //wait
        }
    }

    public void unlock(){
        int i = (int) Thread.currentThread().getId();
        flag[i]=false;
    }


}




























