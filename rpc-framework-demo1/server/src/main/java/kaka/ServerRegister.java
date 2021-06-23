package kaka;

/**
 * 向注册中心添加服务
 */
public class ServerRegister {

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            public void run() {
                try {
                    // new服务中心
                    RegisterCenter serviceServer = new RegisterCenter(8888);
                    // 注册订单服务至注册中心
                    serviceServer.register("订单服务", OrderInterface.class, OrderServiceImpl.class);
                    // 运行我们的服务
                    serviceServer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
