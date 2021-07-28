package countdownlatch;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 要是自己实现一个cdl,其实主要就是实现countdown方法与await方法
 */
public class CountDownTest {
    private static final Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException {

        MyLatch myLatch = new MyLatch(2);
        IntStream.rangeClosed(1,2).forEach(i -> new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在工作.....");
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLatch.countDown();
        },String.valueOf(i)).start());

        myLatch.await();
        System.out.println(">>>>>>>>");
        System.out.println(">>>>>>>>前两个线程已经完成,接下来执行第三个线程");
    }
}



























