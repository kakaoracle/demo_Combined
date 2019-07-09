## 反射的作用
- 主要作用是运行状态下能够获取该类任意属性与方法
- 次要作用1,从配置文件中读取类名,创建实例,不用new,从而达到解耦
    (不用new指的是不用手写,但是也需要反射调用new方法比如Class.forName(beanDefinition.getClassName()).newInstance())
- 次要作用2,Method.invoke执行方法
- 次要作用3,适用于工厂模式,比如工厂模式中,多个类继承同个接口,然后工厂判断类名,new 该类,再增加一个类就需要修改工厂中new 这个类,但是如果用反射
就可以不改动工厂代码,新增的类地址依旧可以创建这个类,根据地址创建实例和根据类创建实例的区别就是在,地址是省略手写创建类这个步骤的.

## newInstance和new的区别
比如spring中的spring容器,有一个hashMap<String,Bean>,其中的bean的实例化是通过读取配置文件名
1. newInstance()只能调用无参构造函数.
2. newInstance()是一个方法,new是一个关键字,class.forName("")返回的是类,Class.forName().newInstance()返回的是object
    forName是将类放到jvm中(类指的就是.class文件,是一个文件),newInstance是一个类实例,属性是一个object
    用newInstance好处就是只要多个example都继承自exampleInterface,那么就可可以更加灵活?:
    String className = readfromXMlConfig;//从xml 配置文件中获得字符串
    class c = Class.forName(className);
    factory = (ExampleInterface)c.newInstance();
3. 
## 注意点:
1. 创建类指的是创建一个.class文件,创建一个实例指的是创建一个Object对象
2. new的时候是已经有类,但是没有实例,new一个类出来一个实例,但是反射就可以不用类,直接根据地址,反射出一个类,并生成实例

