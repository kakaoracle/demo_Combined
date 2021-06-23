package publishScriptionModel;

/**
 * 订阅者实现类
 */
public class SubscriberImp implements ISubscriber {

    private String messageType;

    public SubscriberImp(String messageType) {
        this.messageType = messageType;
        //注册到订阅器
        registry();
    }

    @Override
    public String getMessageType() {
        return messageType;
    }

    @Override
    public void receiveMessage(Object message) {
        //此处做一些计算,增加订阅者处理消息耗时
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                int i1 = i + j;
            }
        }
        System.out.println("消息类型："+this.messageType+"  消息："+message.toString() + ",线程名称：" + Thread.currentThread().getName());
    }
}