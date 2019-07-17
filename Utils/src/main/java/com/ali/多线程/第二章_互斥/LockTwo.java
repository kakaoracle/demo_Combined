package com.ali.多线程.第二章_互斥;

/**
 * @description:假设两线程的id为0与1,当一个线程完全先于另一个线程就会出现死锁
 * 关键点1:    找出非原子操作语句,victim == i在赋值前需要读取victim的值,不同的线程同一时间读取的是同一个victim的值
 * 关键点2:    结论中死锁与否针对的是最开始没有被污染的线程,污染者线程不作讨论
 * @author: DeZhao Chen
 * @create: 2019-07-15 13:17
 **/
public class LockTwo implements Lock {

    private volatile int victim;

    //判断前前线程0:i=0,victim=0;判断前线程1:i=1,victim=1,判断后线程0上锁
    //判断前前线程1:i=1,victim=1;判断前线程0:i=0,victim=0,判断后线程1上锁
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

















