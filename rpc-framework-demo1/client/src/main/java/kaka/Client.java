package kaka;

/**
 * rpc的客户端，调用远端服务
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //动态代理获取我们的对象
        OrderInterface orderService = RpcClientFrame.getRemoteProxyObj(OrderInterface.class);
        //此处的orderService.findOrder是代理后的类
        System.out.println(orderService.findOrder("20200613001"));
    }
}
