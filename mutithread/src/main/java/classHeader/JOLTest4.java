package classHeader;

import org.openjdk.jol.info.ClassLayout;

/*
* 验证如果进行了hashcode就不能偏向
* */
public class JOLTest4 {
    static A a;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        a = new A();
        a.hashCode();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a){
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
