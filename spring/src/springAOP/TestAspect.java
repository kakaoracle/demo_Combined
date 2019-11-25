package springAOP;

import org.aopalliance.intercept.Joinpoint;


/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-11-07 11:46
 **/
public class TestAspect {
    public void after(Joinpoint jp){
        System.out.println("after");
    }


    public  void doBefore(Joinpoint jp){
        System.out.println("before");
    }

}
