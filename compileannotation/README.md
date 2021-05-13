## Annotations

This module contains articles about Java annotations

### Relevant Articles:

- [Java Annotation Processing and Creating a Builder](https://www.baeldung.com/java-annotation-processing-builder)

### 三个模块关系
- annotation-processor: 注解与解析器工程,
  1. 里面注释掉了google的autoservice依赖,这个依赖功能是源码中的resources目录
  下不需要写javax.annotation.processing.Processor文件,会在class目录下自动生成(当然,要在对应processor类上加@autoservice
  注解)
  2. 因为要先编译processor,再编译所在工程,所以需要添加maven插件(具体见pom文件)
  3. builderProperty注解作用: 让使用该注解的类在编译后新增一个类,类名+Builder
  4. MyGetter注解作用: 生成get方法
- annotation-user: 使用注解的工程
  1. 工程中的test类中的方法,new PersonBuilder(),如果不编译的话会报类找不到,编译后就不报了
- 由于二者同时依赖于父工程,因此编译时无法编译processing工程后直接编译user(会报错,maven依赖关系问题),看效果需要直接编译
    父工程,以后有时间可以尝试直接变为父子关系工程,不要在父工程中变成兄弟关系
- idea中不需要开启所谓的process功能,什么都不需要动
- 为什么示例工程的new PersonBuilder()不报红?这个类只存在在target目录下,代码目录下没有