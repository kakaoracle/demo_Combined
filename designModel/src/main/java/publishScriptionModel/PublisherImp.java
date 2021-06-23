package publishScriptionModel;

/**
 * 发布者实现类
 */
public class PublisherImp implements IPublisher {
    /**
     * 消息类型
     */
    private String messageType;

    public PublisherImp(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String getMessageType() {
        return messageType;
    }
}
