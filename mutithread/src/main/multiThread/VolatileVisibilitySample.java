package multiThread;
/*
* volatile的可见性
*
* */
public class VolatileVisibilitySample {
    // 这里不加volatile,ThreadB永远不会打印,加上才会打印
    private static volatile boolean initFlag = false;

    public void refresh(){
        this.initFlag = true;
        String threadName = Thread.currentThread().getName();
        System.out.println("线程: "+threadName+":修改共享变量initFlag");
    }

    public void load(){
        String threadName = Thread.currentThread().getName();
        int i = 0;
        while (!initFlag){
        }
        System.out.println("线程: "+threadName+"当前线程察觉到initFlag状态的改变");
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileVisibilitySample sample = new VolatileVisibilitySample();
        Thread threadA = new Thread(()->{
            sample.refresh();
        },"threadA");
        Thread threadB = new Thread(()->{
            sample.load();
        },"threadB");
        threadB.start();
        Thread.sleep(2000);
        threadA.start();
    }

}
