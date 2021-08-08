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
这里面handler是接口,因此需要重写其invoke方法,在这里面socket通信,哪怕是jdk动态代理,如果要实现原方法内容,也要methond.invoke,
动态代理中类加载器参数的作用
2. 主体流程是:
server端将class与方法名注册到容器中 --> client端调用前先生成一个动态代理类 --> 执行的是代理后的类的方法 --> 触发socket通信
   --> server端区分开class的方法,然后本地根据class生成实例 --> 本地执行逻辑  --> 返回值返回给client端  --> client接收到后打印返回值
3. 问题,如果分为三部分,注册中心,provider,soncumer,那么注册中心是打包到provider中么?或者注册中心单独起一个服务,但是这样的话,
全部内存占用不是都在注册中心服务么?
答: 的确是有一个专属的dubbo微服务,根据官网结构流程图得,consumer从注册中心仅仅通过匹配类与方法名,注册中心找到对应服务端
   (当然有负载均衡)对应的服务地址,然后consumer通过动态代理,从而使得方法调用在服务端完成