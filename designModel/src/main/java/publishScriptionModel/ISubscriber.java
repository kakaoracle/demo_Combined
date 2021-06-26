package publishScriptionModel;

public interface ISubscriber {
    //获取此订阅对象需求的消息类型
    String getMessageType();

    //注册到订阅器
    default void registry(){
        SubscribePublish.getSubscribePublish().subcribe(this);
    }
    // 退订
    default void unSubcribe(){
        SubscribePublish.getSubscribePublish().unSubcribe(this);
    }

    //接收消息并处理
    void receiveMessage(Object message) throws Exception;
}
