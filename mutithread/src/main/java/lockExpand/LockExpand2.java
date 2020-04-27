package lockExpand;

import classHeader.A;
import org.openjdk.jol.info.ClassLayout;

public class LockExpand2 {
    static A a;

    public static void main(String[] args) throws InterruptedException {
        a = new A();
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
