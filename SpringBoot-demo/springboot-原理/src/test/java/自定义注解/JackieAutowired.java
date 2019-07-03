package 自定义注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 自定义注解
 * @author: DeZhao Chen
 * @create: 2019-07-03 10:18
 **/
@Retention(RetentionPolicy.RUNTIME)//注解在运行时生效
@Target({ElementType.METHOD, ElementType.FIELD})//可以作用在方法上,也可以作用在属性上
public @interface JackieAutowired {
    public String name() default "";//声明了一个属性name,default表示默认值可以为空
}