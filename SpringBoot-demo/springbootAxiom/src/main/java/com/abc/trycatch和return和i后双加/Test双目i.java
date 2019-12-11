package com.abc.trycatch和return和i后双加;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-12-10 19:29
 **/
public class Test双目i {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    public static void test1(){
        int a = 0;
        for (int i = 0; i < 99; i++) {
            a = a ++;
        }
        System.out.println(a);
    }


    public static void test2(){
        int b = 0;
        for (int i = 0; i < 99; i++) {
            b = ++ b;
        }
        System.out.println(b);
    }

    public static void test3(){
        Integer a = 0;
        int b = 0;
        for (int i = 0; i < 99; i++) {
            a = a ++;
            b = a ++;
        }
        System.out.println(a);
        System.out.println(b);
    }



}
