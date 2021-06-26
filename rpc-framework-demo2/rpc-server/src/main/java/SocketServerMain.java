import kaka.HelloService;
import kaka.config.RpcServiceConfig;
import kaka.remoting.transport.socket.SocketRpcServer;
import kaka.serviceimpl.HelloServiceImpl;

/**
 *
 */
public class SocketServerMain {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketRpcServer socketRpcServer = new SocketRpcServer();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        rpcServiceConfig.setService(helloService);
        // 注册即让rpc框架知道我提供了某个访求,即将方法对应的访问路径比如/user/name生成zk节点
        // 同时将该方法或对象放到统一一个hashmap中,(k,v) = (对象名,对象实例)
        socketRpcServer.registerService(rpcServiceConfig);
        socketRpcServer.start();
    }
}
