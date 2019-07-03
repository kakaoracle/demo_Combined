package com.abc.自定义注解;

import java.lang.annotation.*;

/**
 * @description: 自定义注解
 * @author: DeZhao Chen
 * @create: 2019-07-02 09:46
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface strVal {
    String value();
}
