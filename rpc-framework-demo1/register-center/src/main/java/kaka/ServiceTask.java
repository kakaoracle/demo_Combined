package kaka;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 服务获取后运行线程
 */
public class ServiceTask implements Runnable {

    //客户端socket
    Socket client;

    public ServiceTask(Socket client) {
        this.client = client;
    }

    /**
     * 远程请求达到服务端，我们需要执行请求结果，并且把请求结果反馈至客户端，使用Socket通讯
     */
    @Override
    public void run() {
        //利用Java反射
        //同样适用object流
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        /**
         * 核心处理流程
         * 1.客户端发送的object对象拿到，
         * 2.在采用反射的机制进行调用，
         * 3.最后给返回结果
         */
        try {
            // 获取客户端发来的输入流
            inputStream = new ObjectInputStream(client.getInputStream());
            //顺序发送数据：类名、方法名、参数类型、参数值
            // 1.拿到服务名
            String serviceName = inputStream.readUTF();
            // 2.拿到方法名
            String methodName = inputStream.readUTF();
            // 3.拿到参数类型
            Class<?>[] paramTypes = (Class<?>[]) inputStream.readObject();
            // 4.拿到参数值
            Object[] arguments = (Object[]) inputStream.readObject();
            // 5.要到注册中心根据 接口名，获取实现类
            Class serviceClass = RegisterCenter.serviceRegistry.get(serviceName);
            // 6.使用反射的机制进行调用
            Method method = serviceClass.getMethod(methodName, paramTypes);
            // 7.反射调用方法,把结果拿到
            Object result = method.invoke(serviceClass.newInstance(), arguments);
            // 8.通过执行socket返回给客户端
            outputStream = new ObjectOutputStream(client.getOutputStream());
            // /把结果返回给客户端
            outputStream.writeObject(result);

        } catch (Exception e) {
            System.out.println("服务处理异常");
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != client) {
                    client.close();
                }
            } catch (IOException e) {
                System.out.println("关流异常");
                e.printStackTrace();
            }


        }
    }
}
