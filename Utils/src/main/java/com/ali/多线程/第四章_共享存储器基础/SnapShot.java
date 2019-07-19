package com.ali.多线程.第四章_共享存储器基础;
//用来实现多个寄存器的读写
public interface SnapShot<T> {
    public void update(T v);
    public T[] scan();
}
