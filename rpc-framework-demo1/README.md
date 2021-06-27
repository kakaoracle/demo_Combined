## 工程目录
- client: 客户端调用
- register-center: 服务注册
- server: 服务提供者
## 使用步骤
1. 运行server子工程下的主方法
2. 运行client子工程下的主方法
3. 可以看到client与server的控制台都有输出
4. 模拟多次调用,可以多次执行client工程的主方法
## 说明
1. 本工程是rpc-ramework-demo工程的极简版
2. 本工程没有注册中心,直接写死,也同时没有负载均衡
3. 一般情况下,执行的类的接口是单独一个工程,然后client可以引用,且server对其进行实现,本例中直接在client与server中存在一个同名接口
## 关键点
1. Proxy.newProxyInstance(类加载器,目标类,invocationhandler)
这里面handler是接口,因此需要重写其invoke方法,在这里面socket通信,哪怕是jdk动态代理,如果要实现原方法内容,也要methond.invoke,因此这里
不执行该句,也就自然和原方法内容完全无关,直接会到rpc框架中进行执行,即因此服务端所在机器其实也不会执行实例,只有rpc框架机器才需要大一点来执行服务端
的实例逻辑
动态代理中类加载器参数的作用