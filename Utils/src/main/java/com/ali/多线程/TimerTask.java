package com.ali.多线程;


/**
 * @description: 重写timer, 用于多线程检测
 * @author: DeZhao Chen
 * @create: 2019-07-13 18:42
 **/
public class TimerTask extends java.util.TimerTask {
    private String name;

    public TimerTask() {
    }

    public TimerTask(String inputName){
        this.name = inputName;
    }

    @Override
    public void run() {
        System.out.println("================");
        //打印当前name的内容
        //System.out.println("Current exec name : "+name);
    }
}
