package com.ali.多线程.第四章_共享存储器基础;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-07-19 10:47
 **/
public class SeqSnapshot<T> implements SnapShot<T> {
    T[] a_value;

    public SeqSnapshot(int capacity,T init) {
        a_value = (T[]) new Object[capacity];
        for (int i=0;i< a_value.length;i++){
            a_value[i] = init;
        }
    }

    @Override
    public void update(T v) {
     a_value[(int) Thread.currentThread().getId()] = v;
    }

    //返回数组的一个原子快照
    @Override
    public T[] scan() {
        T[] result = (T[]) new Object[a_value.length];
        for (int i =0;i<a_value.length;i++){
            result[i]=a_value[i];
        }
        return result;
    }
}























