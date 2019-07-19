package com.ali.多线程.第四章_共享存储器基础;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-07-19 11:17
 **/
public class StampedSnap<T> {
    public Long stamp;
    public T value;
    public T[] snap;
    public StampedSnap(T value){
        stamp = 0L;
        value = value;
        snap = null;
    }
    public StampedSnap(Long label,T value,T[] snap){
        this.stamp=label;
        this.value = value;
        this.snap = snap;
    }

}
