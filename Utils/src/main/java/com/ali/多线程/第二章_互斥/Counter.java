package com.ali.多线程.第二章_互斥;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-07-15 10:25
 **/
//单独的这样的方法当多个线程同时调用时无法保证安全因此要实现一个接口Lock
public class Counter {
    private  int value;
    private Lock lock;



    public Counter(int c){
        value = c;
    }

    public int getAndIncrement(){
        lock.lock();
        int temp;
        try {
            temp = value;
            value = temp +1;
        }finally {
            lock.unlock();
        }

        return temp;
    }

}
