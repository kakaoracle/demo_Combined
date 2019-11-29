package com.abc.静态代码块与构造方法与private等;

/**
 * @description: 父类
 * @author: DeZhao Chen
 * @create: 2019-11-29 22:40
 **/
public class SeniorClass {
    static {
        System.out.println("父类静态代码块");
    }

    public SeniorClass() {
        System.out.println("父类构造方法");
    }

    private int privateSenior = 1;
    protected int protectedSenior = 2;
    public int publicSenior =3;
}
