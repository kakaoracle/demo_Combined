package lockExpand;

import classHeader.A;
import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
  禁删
* 验证重偏向
* 老规矩,先禁止掉偏向延迟-XX:BiasedLockingStartupDelay=0
* */
public class LockExpand3 {
    static List<A> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        // 第一个线程
        Thread t1 = new Thread(){
            public void run(){
                for (int i=0;i<20;i++){
                    A a=new A();
                    synchronized (a){
                        System.out.println("生产"+i);
                        list.add(a);
                    }
                }
            }
        };
        t1.start();
        t1.join();
        System.out.println("before t2");
        System.out.println(ClassLayout.parseInstance(list.get(0)).toPrintable());
        // 第二个线程
        Thread t2 = new Thread(){
            int k = 0;
            public void run(){
                for (A a:list){
                    synchronized (a){
                        //System.out.println("消费");
                        if (k==19){
                            System.out.println("t2 ing");
                            System.out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                    }
                    k++;
                }
            }
        };
        t2.start();
    }
}
