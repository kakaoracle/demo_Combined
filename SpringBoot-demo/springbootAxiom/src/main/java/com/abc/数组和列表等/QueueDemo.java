package com.abc.数组和列表等;

/**
 * @description: 队列实现demo
 * @author: DeZhao Chen
 * @create: 2019-10-14 22:37
 **/
public class QueueDemo {
    private  int maxSize;
    private long[] queArray;
    private  int front;  //队头
    private  int rear;   //队尾
    private int nItems;
    public QueueDemo(int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j){
        if (rear == maxSize -1){
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public long remove(){
        long temp = queArray[front++];
        if (front == maxSize){
            front = 0;
        }
        nItems --;
        return temp;
    }

    //peek用来查看某一项的值
    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return nItems ==0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public int size(){
        return nItems;
    }


    public static void main(String[] args) {
        QueueDemo queueDemo = new QueueDemo(5);
        queueDemo.insert(10);
        queueDemo.insert(20);
        queueDemo.insert(30);
        queueDemo.insert(40);

        queueDemo.remove();
        queueDemo.remove();
        queueDemo.remove();

        queueDemo.insert(50);
        queueDemo.insert(60);
        queueDemo.insert(70);
        queueDemo.insert(80);

        while ( !queueDemo.isEmpty()){
            long n = queueDemo.remove();
            System.out.println(n);
        }


    }







}
