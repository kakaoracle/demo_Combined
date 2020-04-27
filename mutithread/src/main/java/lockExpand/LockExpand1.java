package lockExpand;

import classHeader.A;
import org.openjdk.jol.info.ClassLayout;

/*
* 交替执行,偏向锁会升级为轻量锁
*
*   老规矩,先禁止掉偏向延迟-XX:BiasedLockingStartupDelay=0
* */
public class LockExpand1 {
    static A a;

    public static void main(String[] args) throws InterruptedException {
        a = new A();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("t1 lock ing");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        t1.start();
        Thread.sleep(7000);

        synchronized (a){
            System.out.println("main lock ing");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}
