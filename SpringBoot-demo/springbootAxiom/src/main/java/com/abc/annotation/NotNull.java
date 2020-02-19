package com.abc.annotation;

import java.lang.annotation.*;

/*
*   自定义注解,作用于字段上,用来对字段进行操作
* */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
    String name() default "123";
}
