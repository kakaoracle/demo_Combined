package classHeader;

import org.apache.logging.log4j.message.LoggerNameAwareMessage;

/*
* 用来验证偏向锁与轻量级锁的性能差异
*
* */
public class JOLTest {
    public static void main(String[] args) {
        A a = new A();
        long start = System.currentTimeMillis();
        // 调用同步方法10亿次L计算i++
        //
        for (int i=0;i<1000000000L;i++){
            a.parse();
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms",end - start));

    }
}
