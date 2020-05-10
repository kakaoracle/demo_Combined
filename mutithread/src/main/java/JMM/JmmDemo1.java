package JMM;

public class JmmDemo1 {
    private static boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        JmmDemo1 demo1 = new JmmDemo1();
        Thread t1 = new Thread(()->{
            demo1.load();
        },"threadB");
        t1.start();
        Thread.sleep(200);
        // 确保线程1启动后再开始改变
        refresh();
    }
    public static void load(){
        while (!initFlag){
        }
        System.out.println("当前线程察觉到initFlag状态的改变");
    }

    public static void refresh(){
        initFlag = true;
        System.out.println("线程: "+Thread.currentThread().getName()+":修改共享变量initFlag");
    }
}
