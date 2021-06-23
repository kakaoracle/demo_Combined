package publishScriptionModel;

/**
 * 发布者接口
 */
public interface IPublisher {
    /**
     * 获取消息类型
     *		需要子类实现
     *
     * @return 获取消息类型
     */
    String getMessageType();

    /**
     * 	生产消息 （同步处理）
     * 		默认实现
     *
     * @param message	消息实体
     */
    default void publishMessageBySync(Object message){
        if (getMessageType() == null){
            throw new IllegalArgumentException("消息发送失败!消息类型为null.");
        }
        SubscribePublish.getSubscribePublish().publishMessageBySync(getMessageType(), message);
    }

    /**
     * 生产消息 （异步处理）
     * 		默认实现
     *
     * @param message 消息实体
     */
    default void publishMessageByAsyn(Object message){
        if (getMessageType() == null){
            throw new IllegalArgumentException("消息发送失败!消息类型为null.");
        }
        SubscribePublish.getSubscribePublish().publicMessageByAsyn(getMessageType(), message);
    }
}
