package classHeader;

import org.openjdk.jol.info.ClassLayout;

/*
* 与markwordtest进行对比,这是一个有锁状态下,研究markword
*
* */
public class MarkWordLockTest {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        L l = new L();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
        synchronized (l){
            System.out.println("locking");
        }
        System.out.println("after lock");
        // JVM计算的hashcode
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }
}
