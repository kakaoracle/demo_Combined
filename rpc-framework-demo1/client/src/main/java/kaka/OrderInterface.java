package kaka;

/**
 * 订单服务接口
 */
public interface OrderInterface {
    /**
     * 根据订单id查询订单
     *
     * @param orderId
     * @return
     */
    String findOrder(String orderId);
}
