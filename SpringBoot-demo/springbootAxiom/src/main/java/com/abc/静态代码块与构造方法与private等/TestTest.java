package com.abc.静态代码块与构造方法与private等;

/**
 * @description: 测试
 * @author: DeZhao Chen
 * @create: 2019-11-29 22:42
 **/
public class TestTest {
    public static void main(String[] args) {
        /*
        * 测试静态代码块和构造方法的执行顺序
        * */
        JuniorClass juniorClass = new JuniorClass();

        /*
        * 测试private,protected和public
        *
        * */
        //System.out.println(JuniorClass.privateSenior);//私有方法,实例也无法访问
        System.out.println(juniorClass.protectedSenior);
        System.out.println(juniorClass.protectedJunior);//子类继承了父类的public和protected级别的变量
        System.out.println(juniorClass.publicSenior);

    }
}
