package com.abc.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CdzGet {
    //String value();
    String uuidTest() default "kakaoracle";//这里有default的值,则使用注解时就可以直接使用,否则每一个注解都要赋值
}
