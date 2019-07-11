package com.abc.sliceProgram.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//这个是aspectjar包单独做出来的注解
public class AspectDemo {
    @Pointcut("execution(* com.abc.sliceProgram.dao.*.*(..))")//对某一包下所有的方法进行切面
    public void pointCut() {

    }

    @Before("pointCut()")//通知要和连接点关联起来
    public void before() {
        System.out.println("**前置通知");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("**后置通知");
    }
}
