package WatchModel;

/**
 * @description: 测试
 * @author: DeZhao Chen
 * @create: 2019-12-01 22:34
 **/
public class ClinetTest {
    public static void main(String[] args) {
        //创建观察者
        WatcherOne watcherOne = new WatcherOne("观察者/订阅者1号");
        //创建一个被观察者
        ObjectOne user1=new ObjectOne();
        //订阅公众号(被观察者发生事件,通知观察者)
        user1.attach(watcherOne);
        //公众号更新发出消息给订阅的微信用户
        user1.notify("小明专栏更新了");
    }
}
