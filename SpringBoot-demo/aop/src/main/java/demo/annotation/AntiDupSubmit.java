package demo.annotation;

import java.lang.annotation.*;

/*
* 防止重复提交 anti duplicate submission
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AntiDupSubmit {
    String key() default "";
}
