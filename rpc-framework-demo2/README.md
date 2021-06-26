# 参考链接
https://github.com/Snailclimb/guide-rpc-framework
# 工程目录
- example-server: 注册服务,注意这并不是rpc框架,只是使用方的一员
- example-client: 消费服务,调用执行server中的方法
- rpc-framework-simple: 整个框架,server与client仅是使用示例
- rpc-framework-common: 工具类包
# 说明
1. 启动zk
2. 启动server端程序(入口是SocketServerMain)
3. 启动client端程序发现能够执行方法
4. nettyServerMain与SocketServerMain是两种实现方法,前者对应基础版本,后者
更换为netty,同时前者调用的是serviceimpl,后者调用的是serviceimpl2
# 要点
1. rpcClient是用的接口,rpcServer是对该接口的实现,因此不存在可以直接调用rpcServer实现类的说法,因为可以将接口完全独立成第三方工程,此时
rpcClient工程就不再引入rpcServer工程
2. 