package kaka;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 注册中心
 */
public class RegisterCenter {

    // 线程池
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // 存放服务注册的容器
    public static final HashMap<String, Class> serviceRegistry = new HashMap<String, Class>();

    private static boolean isRunning = false;

    private static int port;

    public RegisterCenter(int port) {
        this.port = port;
    }

    /**
     * 服务的注册:socket通讯+反射
     * @param serviceInterface
     * @param impl
     */
    public void register(String serviceName, Class serviceInterface, Class impl) {
        System.out.println(serviceName + "  已加入注册中心！");
        serviceRegistry.put(serviceInterface.getName(), impl);
        System.out.println("注册中心列表：" + serviceRegistry.toString());
    }

    /**
     * 启动服务注册中心
     * @throws IOException
     */
    public void start() throws IOException {
        //服务器监听
        ServerSocket serverSocket = new ServerSocket();
        //监听绑定端口
        serverSocket.bind(new InetSocketAddress(port));
        System.out.println("服务中心已启动....");
        try {
            while (true) {
                // 监听客户端的TCP连接，接到TCP连接后将其封装成task，
                // 由线程池执行,并且同时将socket送入(server.accept()=socket)
                executor.execute(new ServiceTask(serverSocket.accept()));
            }
        } finally {
            serverSocket.close();
        }
    }
}





