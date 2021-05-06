package com.hello.aspectj;

public aspect LoggingAspect {
    pointcut logPointcut():call(* ApiTest.hi(..));

    void around():call(void ApiTest.hi(..)){
        System.out.println("call 开始...");
        proceed();
        System.out.println("call 结束...");
    }

    before(): logPointcut(){
        System.out.println("方法执行 before");
    }

    after(): logPointcut(){
        System.out.println("方法执行 after");
    }
}
