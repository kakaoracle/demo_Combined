package com.abc.trycatch和return和i后双加;

import org.junit.jupiter.api.Test;

/**
 * @description: trycatch和return
 * @author: DeZhao Chen
 * @create: 2019-12-10 19:17
 * 结论1:  return和finally同时存在,finally一定执行
 **/
public class TestReturnFinally {
    public static void main(String[] args) {
        System.out.println(test1());
    }
    public static int test1(){
        int i = 0;
        try{
            i++;
            return i++;
        }catch (Exception e){

        }finally {
            return 10;
        }
    }



}
