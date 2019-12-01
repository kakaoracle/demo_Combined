package 观察者模式;

/**
 * @description: 观察者的具体实现类
 * @author: DeZhao Chen
 * @create: 2019-12-01 19:16
 **/
public class WatcherOne implements Watcher {

    // 微信用户名
    private String name;
    public WatcherOne(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }

}
