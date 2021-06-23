package publishScriptionModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 消息订阅器
 */
public class SubscribePublish {
    /**
     * 订阅者map，key为消息类型
     */
    private Map<String, List<ISubscriber>> subcriberMap = new HashMap<>();

    /**
     * 获取计算机有几个核
     */
    private int processors = Runtime.getRuntime().availableProcessors();

    /**
     * 创建线程池:
     * 参数：
     * 核心线程数：计算机内核数
     * 最大线程数：计算机内核数*5
     * 空闲时间：60s，超过60s超过核心线程数的空闲线程被杀死
     * 任务队列长度：200
     * 线程池工厂：使用了jdk默认工厂
     * handler（队列满时的任务拒绝策略）：让提交任务的线程去执行
     */
    private ExecutorService threadPool = new ThreadPoolExecutor(processors, processors * 5, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(200), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 本类实例
     */
    private static SubscribePublish subscribePublish = new SubscribePublish();

    /**
     * 私有此类的构造
     * 使其不允许被外界实例化，仅类内部存在一个实例
     */
    private SubscribePublish() {
    }

    /**
     * 注册订阅者
     *
     * @param subscriber 订阅对象
     */
    public void subcribe(ISubscriber subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("订阅失败!订阅对象不能为null.");
        }
        //获取消息类型
        String messageType = subscriber.getMessageType();
        if (messageType == null) {
            throw new IllegalArgumentException("订阅失败!订阅对象的消息类型不能为null.");
        }
        //绑定订阅对象
        if (subcriberMap.get(messageType) == null) {
            List<ISubscriber> subcribers = new ArrayList<>();
            subcribers.add(subscriber);
            subcriberMap.put(messageType, subcribers);
        } else {
            subcriberMap.get(messageType).add(subscriber);
        }
    }

    /**
     * 退订
     *
     * @param subscriber 订阅对象
     */
    public void unSubcribe(ISubscriber subscriber) {
        if (subscriber != null && subscriber.getMessageType() != null) {
            List<ISubscriber> subscribers = subcriberMap.get(subscriber.getMessageType());
            if (subscribers != null) {
                subscribers.remove(subscriber);
            }
        }
    }

    /**
     * 生产同步消息
     *
     * @param messageType 消息类型
     * @param message     消息
     */
    public void publishMessageBySync(String messageType, Object message) {
        sendMessage(messageType, message);
    }

    /**
     * 生产异步消息
     *
     * @param messageType 消息类型
     * @param message     消息
     */
    public void publicMessageByAsyn(String messageType, Object message) {
        /**
         * 此处把for循环写在threadPool.submit方法外面代表每个订阅者对消息的处理都是由一个线程执行
         * 如果把for循环写在threadPool.submit方法里面则代表一组相同类型的订阅者对同一个消息的处理是由一个线程处理
         */
        subcriberMap.get(messageType).forEach(subscriber -> {
            this.threadPool.submit(() -> {
                try {
                    subscriber.receiveMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
    }

    private void sendMessage(String messageType, Object message) {
        subcriberMap.get(messageType).forEach(subscriber -> {
            try {
                subscriber.receiveMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 获取本类实例
     *
     * @return SubscribePublish对象
     */
    public static SubscribePublish getSubscribePublish() {
        return subscribePublish;
    }
}
