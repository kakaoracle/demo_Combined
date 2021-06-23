## 工程目录
- client: 客户端调用
- register-center: 服务注册
- server: 服务提供者
## 说明
1. 本工程是rpc-ramework-demo工程的极简版
2. 本工程没有注册中心,直接写死,也同时没有负载均衡
3. 一般情况下,执行的类的接口是单独一个工程,然后client可以引用,且server对其进行实现,本例中直接在client与server中存在一个同名接口