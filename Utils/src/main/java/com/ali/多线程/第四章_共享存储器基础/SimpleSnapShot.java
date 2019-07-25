package com.ali.多线程.第四章_共享存储器基础;

/**
 * @description:update()方法是无等待的,而其scan()方法则是无障碍的
 * @author: DeZhao Chen
 * @create: 2019-07-19 11:05
 **/
public class SimpleSnapShot<T> implements SnapShot<T> {


    @Override
    public void update(T v) {

    }

    @Override
    public T[] scan() {
        return null;
        //return new T[0];
    }
}
