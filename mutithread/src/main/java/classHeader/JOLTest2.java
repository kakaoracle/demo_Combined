package classHeader;

import java.util.concurrent.CountDownLatch;

/*
* 测试重量级锁
*
*
* */
public class JOLTest2 {
    static CountDownLatch countDownLatch =new CountDownLatch(1000000000);

    public static void main(String[] args) throws InterruptedException {
        final AH a = new AH();
        long start = System.currentTimeMillis();

        // 有明确的两个资源竞争,这是重量级锁了
        for (int i = 0;i<2;i++){
            new Thread(){
                @Override
                public void run() {
                   while (countDownLatch.getCount() > 0){
                       a.parse();
                   }
                }
            }.start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms",end - start));
    }
}
