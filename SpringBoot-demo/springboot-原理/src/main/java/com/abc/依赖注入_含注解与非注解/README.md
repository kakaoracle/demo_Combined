## 依赖注入
1. 整个工程是复制类的加载和实例化工程
2. 依赖注入,上一步的类的加载和实例化是直接从application的getbean(就是hashMap中的id)获取bean,调用方法
但是依赖注入则是在一个bean中注入另一个bean
3. 将demoDao作为成员变量，添加setter和getter方法,这个时候还不是依赖注入,bean之间未解耦
4. 与类的实例化的区别是实例化类到hashmap中,上一章就是一个bean实例化就好,但是bean中没有属性(变量与其他bean)
从配置文件中获取到的是两个beanid,分别是demoService和demoDao,但是demoService中还有属性(一个变量,一个类)


## 其他说明
1. 内省,Introspector,是一个方法,用来获取一个类的所有描述信息,包括属性和方法,
PropertyDescriptor用来操作一个类的所有信息
2. 一般的nullPointer都是因为invoke出错



