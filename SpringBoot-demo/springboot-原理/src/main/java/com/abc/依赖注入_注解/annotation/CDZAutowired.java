package com.abc.依赖注入_注解.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 自定义注解
 * @author: DeZhao Chen
 * @create: 2019-07-07 11:35
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD.METHOD,ElementType.FIELD})
public @interface CDZAutowired {
    public String name() default "";
}
