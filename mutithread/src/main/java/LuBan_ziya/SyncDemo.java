package LuBan_ziya;
/*
* no modify
*   synnchronized 实现一把锁
* 偏向锁
* 轻量级锁
* 重量级锁
* */
public class SyncDemo {
    Object o = new Object();

    static{
        System.loadLibrary("kakaNative");
    }

    public static void main(String[] args) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        SyncDemo syncDemo = new SyncDemo();
        syncDemo.start();
    }

    public void start(){
        Thread thread1 = new Thread(){
            public void run(){
                while (true){
                    try {
                        sync();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            public void run(){
                while (true){
                    try {
                        sync();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.setName("t1");
        thread2.setName("t2");

        thread1.start();
        thread2.start();
    }

    // 用来打印os分配的线程id
    public native void tid();

    public void sync() throws Exception{
        synchronized (o){
            tid();
        }
    }

}
