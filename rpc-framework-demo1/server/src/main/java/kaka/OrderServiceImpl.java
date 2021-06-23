package kaka;

/**
 * 服务实现类
 */
public class OrderServiceImpl implements OrderInterface {

    @Override
    public String findOrder(String orderId) {
        System.out.println("----------------- select order start-----------------------");
        System.out.println("订单号：" + orderId);
        System.out.println("正在查询数据库.......");
        String result = "【订单号：" + orderId + ", 订单金额：" + (Math.random() * 100) + 1 + "】";
        System.out.println("查询成功！订单信息为：" + result);
        System.out.println("-----------------  select order end -----------------------");
        return result;
    }
}
