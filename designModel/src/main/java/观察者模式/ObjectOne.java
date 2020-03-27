package 观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 观察者实例
 * @author: DeZhao Chen
 * @create: 2019-12-01 22:32
 **/
public class ObjectOne implements Object {



    //储存订阅公众号的微信用户
    private List<Watcher> weixinUserlist = new ArrayList<Watcher>();

    @Override
    public void attach(Watcher watcher) {
        weixinUserlist.add(watcher);
    }

    @Override
    public void detach(Watcher watcher) {
        weixinUserlist.remove(watcher);
    }

    @Override
    public void notify(String message) {
        for (Watcher watcher : weixinUserlist) {
            watcher.update(message);
        }
    }

}
