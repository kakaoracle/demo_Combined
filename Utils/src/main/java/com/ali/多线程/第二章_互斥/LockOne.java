package com.ali.多线程.第二章_互斥;

/**
 * @description:
 * 前提一:     只有两个线程(不是多个线程),线程0与1的id分别为0和1
 * 前提二:     两个线程性质是一个是主研究对象,一个是篡改者,先执行谁谁是主研究对象
 * 关键点1:    临界区:临界区指的是锁(一个方法)本身在执行过程中由于方法中多个语句中存在非原子操作语句,因此多个线程同时上锁,就会产生问题
 *              不是业务的问题,而是锁本身的问题,比如flag[i] = true的时候,是两个操作,读取flag[i]的值和赋值flag[i]的值,
 *              因此有可能flag[i]为0,但是在赋值前又有其他线程把flag[i]变为1
 * 关键点2:    布尔数组默认都是false
 * 关键点3:    结论中死锁与否针对的是最开始没有被污染的线程,污染者线程不作讨论
 * 关键点4:    成员变量是会因为多线程而变的,局部变量不变(因为方法栈)
 * 成功获取到锁:执行上锁语句后,能够执行完毕并执行下面的业务代码,锁住的意思就是其他线程执行上锁语句,会卡在上锁语句
 *              的死循环中导致无法执行后续的业务代码
 * 结论:      两个线程交叉执行可能会死锁,但是如果是先执行线程0,再执行线程1,就不会死锁
 * @author: DeZhao Chen
 * @create: 2019-07-15 11:15
 **/
public class LockOne implements Lock {
    private boolean[] flag = new boolean[2];

    public boolean[] getFlag() {
        return flag;
    }

    public void setFlag(boolean[] flag) {
        this.flag = flag;
    }

    //线程0先:
    //      不篡改:循环前i=0,j=1,[true,false];
    //      篡改:  i,j不变(局部变量,仅研究线程0),[true,true],线程0死循环
    //线程1先:.....
    @Override
    public void lock() {
        int i = (int) Thread.currentThread().getId();
        int j = 1 - i;
        flag[i] = true;
        while (flag[j]){

        }
    }

    @Override
    public void unlock() {
        int i  = (int) Thread.currentThread().getId();
        flag[i] = false;
    }
}
