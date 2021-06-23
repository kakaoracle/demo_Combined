package WatchModel;

/*
* 被观察者接口
* */
public interface Object {

    /**
     * 增加观察者
     */
    void attach(Watcher watcher);
    /**
     * 删除观察者
     */
    void detach(Watcher watcher);
    /**
     * 通知观察者更新消息
     */
    void notify(String message);

}
