package com.abc.annotation;

import com.abc.annotation.bean.Info;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class CheckNullAspect {

    @Before("@annotation(notNull)")
    public void paramValid(JoinPoint point, NotNull notNull) {
        Object[] paramObj = point.getArgs();
        System.out.println("====="+paramObj.toString());
    }


}
