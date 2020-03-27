package 观察者模式;

/*
* 被观察者接口
* */
public interface Object {

    /**
     * 增加观察者
     */
    public void attach(Watcher watcher);
    /**
     * 删除观察者
     */
    public void detach(Watcher watcher);
    /**
     * 通知观察者更新消息
     */
    public void notify(String message);

}
