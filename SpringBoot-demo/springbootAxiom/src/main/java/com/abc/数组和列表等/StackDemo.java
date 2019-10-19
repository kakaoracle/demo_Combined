package com.abc.数组和列表等;

/**
 * @description: 实现数组结构
 * @author: DeZhao Chen
 * @create: 2019-10-14 20:22
 * 注意点:栈用数组或者链表实现,用数组的话,pop一个只是将游标往前移一位,后一位数据还存在,但是用pop访问不到了已经,随着push
 * 会再次被覆盖
 **/
public class StackDemo {
    private int maxSize;
    private  long[] stackArray;
    private  int top;
    public StackDemo(int s){
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    //push
    public void push(long j){
        stackArray[++top] = j;
    }

    //pop
    public long pop(){
        return stackArray[top--];
    }

    //peek,查看头部数据
    public long peek(){
        return stackArray[top];
    }

    //isFull
    public boolean isFull(){
        return (top == maxSize - 1);
    }

    //isEmpty
    public boolean isEmpty(){
        return ( top == -1);
    }

    //测试
    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo(10);
        stackDemo.push(20);
        stackDemo.push(40);
        stackDemo.push(60);
        stackDemo.push(80);
        stackDemo.pop();
        while ( !stackDemo.isEmpty()){
            long pop = stackDemo.pop();
            System.out.println(pop);
        }
    }
}
















