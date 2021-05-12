package Semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量实现同时只能4人用餐
 * 要求,手动用synchronize实现信号量,替换jdk中的信号量类(在MySemaphonre中实现了)
 */
public class SemaphoreTest01 {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(4);
        //MySemaphore semaphore=new MySemaphore(4);
        SemaphoreTest01 test01 = new SemaphoreTest01();
        for (int i = 0; i <100 ; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    test01.test(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    //这句最好放在release之前，否则可能出现多放几个进来的错觉
                    System.out.println(">>>>>>"+finalI +"号桌客人用餐完毕，请下一位客人进场用餐");
                    semaphore.release();
//                    System.out.println(">>>>>>"+finalI +"号桌有客人用餐完毕，请下一位进场用餐");
                }
            }).start();
        }
    }

    public void test(int finalI){
        System.out.println(">>>>>>"+finalI +"号桌有客人进来用餐");
    }
}
