package com.abc.数组和列表等;

/**
 * @description: 实现数组结构
 * @author: DeZhao Chen
 * @create: 2019-10-14 20:22
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

    //peek
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
        while ( !stackDemo.isEmpty()){
            long pop = stackDemo.pop();
            System.out.println(pop);
        }
    }
}
















