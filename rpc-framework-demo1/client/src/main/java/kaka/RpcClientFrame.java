package kaka;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * rpc框架的客户端代理部分
 */
public class RpcClientFrame {

    /**
     * 远程服务的代理对象，参数为客户端要调用的的服务
     * @param serviceInterface
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T getRemoteProxyObj(final Class<?> serviceInterface) throws Exception {

        // 默认端口8888
        InetSocketAddress serviceAddr = new InetSocketAddress("127.0.0.1",8888);
        // 1.将本地的接口调用转换成JDK的动态代理，在动态代理中实现接口的远程调用
        // 进行实际的服务调用(动态代理)
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface},new DynProxy(serviceInterface,serviceAddr));
    }

    /**
     * 动态代理类，实现了对远程服务的访问
     */
    private static class DynProxy implements InvocationHandler {
        // 接口
        private final Class<?> serviceInterface;
        // 远程调用地址
        private final InetSocketAddress addr;

        // 构造函数
        public DynProxy(Class<?> serviceInterface, InetSocketAddress addr) {
            this.serviceInterface = serviceInterface;
            this.addr = addr;
        }

        /**
         * 动态代理类，增强：实现了对远程服务的访问
         * @param proxy
         * @param method
         * @param args
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            Socket socket = null;
            ObjectInputStream objectInputStream = null;
            ObjectOutputStream objectOutputStream = null;
            try {
                // 1.新建一个Socket
                socket = new Socket();
                socket.connect(addr);
                //往远端 发送数据，按照顺序发送数据：类名、方法名、参数类型、参数值
                // 1.拿到输出的流
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                // 2. 发送 调用方法的 类名,使用UTF-8避免乱码
                objectOutputStream.writeUTF(serviceInterface.getName());
                // 3.发送 方法名
                objectOutputStream.writeUTF(method.getName());
                // 4.发送 参数类型,使用Object
                objectOutputStream.writeObject(method.getParameterTypes());
                //5 .发送 参数的值,使用UTF-8避免乱码
                objectOutputStream.writeObject(args);
                // 6.刷新缓冲区，使得数据立马发送
                objectOutputStream.flush();
                // 7.立马拿到远程执行的结果
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                // 8.我们要把调用的细节打印出来
                System.out.println("远程调用成功！" + serviceInterface.getName());
                //最后要网络的请求返回给返回
                return objectInputStream.readObject();
            } finally {
                socket.close();
                objectOutputStream.close();
                objectInputStream.close();

            }
        }
    }
}


