package axiom.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.PARAMETER})
public @interface CheckNull {

    /**
     * 作用于方法和参数上，表面当前校验属于哪一组
     * 不设置的话，无需校验参数的属性
     */
    String group() default "";
}
