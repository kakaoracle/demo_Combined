package classHeader;

import org.openjdk.jol.info.ClassLayout;

public class JOLTest3 {
    static A a;

    public static void main(String[] args) throws InterruptedException {
        a =new A();
        System.out.println("before lock");

        System.out.println(ClassLayout.parseInstance(a).toPrintable());//无锁

        Thread t1 = new Thread(){
            public void run(){
                synchronized (a){
                    try {
                        Thread.sleep(5000);
                        System.out.println("t1 release");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        System.out.println("t1 lock ing");
        // 这里是轻量锁,因为主线程没有加锁,此时t1加上锁,且默认偏向延迟,且没有竞争,这时是轻量锁
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        sync();
        System.out.println("after lock");
        // 主线程也要来拿锁,这时是重量锁
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.gc();
        System.out.println("after gc");
        // 重量级锁被释放为无锁,且gc标志位+1
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }
    public static void sync(){
        synchronized (a){
            System.out.println("t1 main lock");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }

}
