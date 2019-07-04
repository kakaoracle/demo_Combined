## 类的加载和实例化
1. 写一个main函数,这次工程用一个test类来表示
2. main函数中就一个方法,用来加载配置文件
3. 用工厂模式new一个解析器来解析配置文件,解析的目的就是获取对应的bean的id和属性中的类的路径
(也就是说,dao的实现类才是加载的类,根本没有接口什么事情,只是这个bean和接口同名而已)
4. 依次实例化类,将配置文件中的id和路径变成一个hashMap<id,bean>

## 自定义注解

## 用到的模式
1. 工厂模式
parserFactory用到的是工厂模式,用来解析json或者xml,实现是传两个参数,一个是文件,一个是类型,
有三个类,parserFactory,parser接口,jsonParser实现parser,xmlParser实现parser
首先将type传入到工厂,返回一个parser,当然,具体返回的是jsonParser或者xmlParser,接口就是这样用的!!!
2. 反射,用处就是比如功能是由用户配置的,程序写完时没有文件,因此需要根据路径动态读取用户的配置文件