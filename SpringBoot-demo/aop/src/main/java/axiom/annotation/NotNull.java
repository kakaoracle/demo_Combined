package axiom.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface NotNull {

    /**
     * 作用于字段上，表面当前注解对哪一些组有效
     */
    String[] groups();
}
