package com.ali.多线程;

import org.junit.Test;

import java.util.Timer;

/**
 * @description: 从timer入手, 检测timer多线程属性
 * @author: DeZhao Chen
 * @create: 2019-07-13 18:41
 **/
public class testTimerWithThread {
    @Test
    public void testTimer(){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask();
        timer.schedule(timerTask,0L,500L);
        /*TimerTask timerTask = new TimerTask("1");
        timer.schedule(timerTask,50);*/
    }

}








