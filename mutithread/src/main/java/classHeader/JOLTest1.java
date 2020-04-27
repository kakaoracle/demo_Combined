package classHeader;

import org.openjdk.jol.info.ClassLayout;

/*
* 验证轻量锁
* 注意不要在vmOption设置取消偏向延迟
*
* */
public class JOLTest1 {
    static A a;

    public static void main(String[] args) throws Exception {
        a = new A();
        Thread.sleep(4000);
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        sync();
        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    public static void sync(){
        synchronized (a){
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }

}
