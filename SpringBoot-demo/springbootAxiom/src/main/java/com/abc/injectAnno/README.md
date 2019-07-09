1. 只涉及了属性为方法与类的依赖注入,没有涉及将注解标在类上
2. 注解的target注意不是@Target({ElementType.FIELD.METHOD,ElementType.FIELD})
而是@Target({ElementType.METHOD, ElementType.FIELD})