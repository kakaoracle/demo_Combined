package kaka;

import kaka.config.RpcServiceConfig;
import kaka.proxy.RpcClientProxy;
import kaka.remoting.transport.RpcRequestTransport;
import kaka.remoting.transport.socket.SocketRpcClient;

/**
 * rpc调用指的是,目标方法与类都在依赖中,
 * @author kaka
 * @createTime 2020年05月10日 07:25:00
 */
public class SocketClientMain {
    public static void main(String[] args) {
        RpcRequestTransport rpcRequestTransport = new SocketRpcClient();
        // 相当于java中的bean
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        //
        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcRequestTransport, rpcServiceConfig);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String hello = helloService.hello(new Hello("111", "222"));
        System.out.println(hello);
    }
}
