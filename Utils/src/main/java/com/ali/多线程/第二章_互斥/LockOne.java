package com.ali.多线程.第二章_互斥;

/**
 * @description:
 * 假设一:     只有两个线程,线程0与1的id分别为0和1
 * 假设二:     lock方法可能同时被执行多次
 * 关键点1:    找出非原子操作语句,只有非原子操作,才会产生线程问题
 *              比如flag[i] = true的时候,是两个操作,读取flag[i]的值和赋值flag[i]的值,因此有可能flag[i]为0,
 *              但是在赋值前又有其他线程把flag[i]变为1
 * 关键点2:    布尔数组默认都是false
 * 关键点3:    结论中死锁与否针对的是最开始没有被污染的线程,污染者线程不作讨论
 * 关键点4:    private是私有变量,非线程共享;public是公共变量,线程
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

    //线程0先:读取前前i=0,j=1,[false,false];读取前篡改i=1,j=0;读取后本应该[true,false],读取后实际为[false,true],线程0
    //线程1先:读取前前i=1,j=0,[false,false];读取前篡改i=0,j=1;读取后本应该[true,false],读取后实际为[true,true],死锁(死循环)
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
