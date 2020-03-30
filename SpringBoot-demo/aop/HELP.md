# 介绍
axiom是原理探讨
demo是工程示例:服务端禁止重复提交请求,5秒内的请求直接返回错误信息
# 切面原理(AOP)
1. springAOP和AspectJ异同
- 二者拥有很多同名注解,比如@pointcut
- spring AOP是通过Spring IOC提供一个简单的AOP实现,并不完整,比如不能应用于静态和final方法,
只能用于SPring容器管理的bean,只支持class和method
- AspectJ是最原始的AOP实现方案,更加健壮,使用时是编译期和类加载时进行织入,也就是生成class文件是已经织入完的
而spring AOP则是运行时织入,class生成后也并无切面,只有运行到被切的方法等才进行织入(用jdk动态代理带教cglib代理),
- AspectJ经过测试是8-35倍快于Sping AOP
2. 使用步骤
- 方式1
- 定义一个切面:关键字aspect
- 定义pointcut:[修饰符 (public,protected...)] pointcut名字():表达式;
- 定义advice:通知类型():pointcut名字(){...逻辑}

- 方式二
- 定义一个切面:关键字aspect
- 定义advice:通知类型():pointcut名字(){...逻辑}
示例:
```
@aspect
class{
    @pointcut("execution(xx方法)")//pointcut表达式
    private void method001(){
    }
    @before("method001()")//pointcut签名
    private void method002(){
    }
}
```
等价于:
```
@aspect
class01{
    @before("execution(xx方法)")
    private void method003(){
}

}
```


3. 怎样在vo的一个id字段上加注解,实现随机id生成?
不能,因为底层都是反射,反射拦截不到变量,除非在vo上也加一个注解,先拦截到class再针对里面被注解的字段进行处理
4. before,around,after,afterReturning,afterThrowing区别以及顺序
正常情况(不抛出异常):around->before->after->afterReturning(无异常抛出)/afterThrowing(有异常抛出)
5. 匹配方法,注解等的表达式:
匹配方法:execution(...)
匹配注解:annotation(...)
匹配方法参数:args(...)
匹配目标类:target(...)/within(...)

6. aop涉及到的依赖
可以直接使用原始依赖(三个一起用,单独用aspectjrt无效)
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjtools</artifactId>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
</dependency>
也可以使用封装好的springaop:
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
    <version>2.2.2.RELEASE</version>
</dependency>
























