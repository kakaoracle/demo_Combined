## 反射的作用
- 从配置文件中读取类名,创建实例,不用new,从而达到解耦
    (不用new指的是不用手写,但是也需要反射调用new方法比如Class.forName(beanDefinition.getClassName()).newInstance())
- Method.invoke执行方法
## newInstance和new的区别
比如spring中的spring容器,有一个hashMap<String,Bean>,其中的bean的实例化是通过读取配置文件名
1. newInstance()只能调用无参构造函数.
2. newInstance()是一个方法,new是一个关键字,class.forName("")返回的是类,Class.forName().newInstance()返回的是object
