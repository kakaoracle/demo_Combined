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
    //线程0先:
    //      临界区前未篡改:i=0,victim=0,线程0正常上锁
    //      临界区前篡改:  i不变,victim=1----线程0也正常上锁
    //线程1先:.....
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

















