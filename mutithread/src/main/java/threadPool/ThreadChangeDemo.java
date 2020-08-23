package threadPool;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池动态配置demo
 * 链接:https://mp.weixin.qq.com/s?__biz=MzIxNTQ4MzE1NA==&mid=2247485631&idx=1&sn=b0d7cd3f337246c79cd08431d9a6d8ec&chksm=9796dec2a0e157d4b8a05b5bc1adcd53bc6ef81112cac5c7dc93370fbbc3baaab717aa5db628&mpshare=1&scene=24&srcid=&sharer_sharetime=1590770455589&sharer_shareid=02f6a2f9fb448b3cffd5701c9b417831&key=959ed3cfa536d687e241bfa72505f78f8e472d1680e3a5f1317aa59ca518ae83b7d85eb391f9ca528ff334845bafa92490df223e64beefac590ebe94c242b9e0fbb7a2bfd991ecd5d152894f288c826a&ascene=14&uin=NzIwMDI2MzA4&devicetype=Windows+10+x64&version=62090529&lang=zh_CN&exportkey=AVh6sHMfa1VFF6E5P9%2BmCkI%3D&pass_ticket=5Hz8F0ib7Rhtn0bRXqZbmkcnvJbOP9zvsR1eCiFR0VKE%2Bj%2FxUZMsc9xBV3Im%2FUmy
 * */
public class ThreadChangeDemo {
    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }
    private static ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(2,5,60, TimeUnit.SECONDS
                ,new LinkedBlockingDeque<>(10),new NamedThreadFactory("kaka"));
    }

    /**
    * 先提交任务给线程池,并修改线程池参数
    * */
    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        for (int i =0;i<15;i++){
            executor.submit(()->{
                threadPoolStatus(executor,"创建任务");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolStatus(executor,"改变之前");
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(10);
        // 预热所有核心线程
        executor.prestartAllCoreThreads();
        threadPoolStatus(executor,"改变之后");
        Thread.currentThread().join();

    }
    // 打印线程池状态
    private static void threadPoolStatus(ThreadPoolExecutor executor,String name) {
        BlockingQueue queue = executor.getQueue();
        System.out.println(Thread.currentThread().getName()+"-"+name+"-:"+
                " 核心线程数:"+executor.getCorePoolSize()+
                " 活动线程数"+executor.getActiveCount()+
                " 最大线程数:"+executor.getMaximumPoolSize()+
                " 线程池活跃度: "+divide(executor.getActiveCount(),executor.getMaximumPoolSize()) +
                " 任务完成数:"+executor.getCompletedTaskCount()+
                " 队列大小:"+(queue.size()+queue.remainingCapacity())+
                " 当前排队线程数:"+queue.size()+
                " 队列剩余大小:"+queue.remainingCapacity()+
                " 队列使用度:"+divide(queue.size(),queue.size()+queue.remainingCapacity())
                );
    }

    private  static  String divide(int num1,int num2){
        return String.format("%1.2f%%",
                Double.parseDouble(num1+"") / Double.parseDouble(num2+"")*100);
    }

}
// 自定义一个threadfactory,仅用来显示线程名称
class NamedThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_SEQ = new AtomicInteger(1);
    private final AtomicInteger mThreadNum = new AtomicInteger(1);
    private final String mPrefix;
    private final boolean mDaemo;
    private final ThreadGroup mGroup;
    public NamedThreadFactory() {
        this("pool-" + POOL_SEQ.getAndIncrement(),false);
    }
    public NamedThreadFactory(String prefix) {
        this(prefix,false);
    }
    public NamedThreadFactory(String prefix,boolean daemo) {
        mPrefix = prefix + "-thread-";
        mDaemo = daemo;
        SecurityManager s = System.getSecurityManager();
        mGroup = ( s == null ) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }
    public Thread newThread(Runnable runnable) {
        String name = mPrefix + mThreadNum.getAndIncrement();
        Thread ret = new Thread(mGroup,runnable,name,0);
        ret.setDaemon(mDaemo);
        return ret;
    }
    public ThreadGroup getThreadGroup() {
        return mGroup;
    }
}

