package classHeader;
/*
* 用来测试重量级锁,只与JOLTest2对应
*
* */
public class AH {
    int i = 0;
    public  synchronized void parse(){
        i++;
        JOLTest2.countDownLatch.countDown();
    }


}
