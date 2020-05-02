package AQS;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
/*
* park和unpark
* */
public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock(true);
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("11111");
                LockSupport.park();
                System.out.println("22222");            }
        };
        t1.start();

        Thread.sleep(3000);
        LockSupport.unpark(t1);
        reentrantLock.lock();
        reentrantLock.unlock();

    }
}
