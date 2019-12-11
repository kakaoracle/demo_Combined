package com.abc.静态代码块与构造方法与private等;

/**
 * @description: 测试有参构造方法的执行顺序
 * @author: DeZhao Chen
 * @create: 2019-12-09 19:26
 * 结论:执行子类的有参构造方法,仅调用父类的无参构造方法,再调用子类的有参构造方法,父类的有参构造方法不会被调用
 **/
public class TestTestTest {
    public static void main(String[] args) {
        JuniorClass juniorClass = new JuniorClass("小明");
    }

}
