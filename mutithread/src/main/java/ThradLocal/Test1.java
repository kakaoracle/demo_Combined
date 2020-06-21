package ThradLocal;

import java.util.concurrent.TimeUnit;

public class Test1 {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set("A");
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set("B");
            threadLocal.set("C");
            System.out.println(threadLocal.get());
        }).start();

    }

}
