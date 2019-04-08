package com.example.demo;



class MyThread extends Thread{
    @Override
    public void run(){
        int i=0;
        while(true){
            i++;
            System.out.println(i);
        }
    }
}
public class JstackCase {
    public static void main(String[] args) {
        MyThread  a=new MyThread();
        a.start();
    }


}
