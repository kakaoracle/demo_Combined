package com.abc.mybatisplus;

import java.net.URLClassLoader;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-09-12 10:29
 **/
public class Test {
    @org.junit.Test
    public void test1(){
        System.out.println(this.getClass().getResource("/").getPath());
    }
}
