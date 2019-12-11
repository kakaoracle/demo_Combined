package com.abc.静态代码块与构造方法与private等;

/**
 * @description: 子类
 * @author: DeZhao Chen
 * @create: 2019-11-29 22:40
 **/
public class JuniorClass extends SeniorClass {
    static {
        System.out.println("子类静态代码块");
    }

    public JuniorClass() {
        System.out.println("子类无参构造方法");
    }

    //子类有参构造方法
    public JuniorClass(String str){
        System.out.println("子类有参构造方法");
    }



    private int privateJunior = 11;
    protected int protectedJunior = 22;
    public int publicJunior =33;

}
