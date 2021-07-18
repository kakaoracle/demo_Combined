package org.apache.ibatis.annotations;

import jdk.nashorn.internal.ir.annotations.Reference;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    String value();
}
