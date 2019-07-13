package com.ali.CountDownLatchUtilTest;

import com.ali.service.HelloService;
import com.ali.utils.CountDownLatchUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.util.calendar.LocalGregorianCalendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class   CountDownLatchUtilTest {
    private static final Logger log = LoggerFactory.getLogger(CountDownLatchUtilTest.class);
    @Autowired
    private HelloService helloService;
    @Test
    public void testSayHello() throws InterruptedException {
        long currentTimeMills = System.currentTimeMillis();
        log.warn("**开始执行");
        //模拟1000个线程并发
        CountDownLatchUtil countDownLatchUtil = new CountDownLatchUtil(1000);
        countDownLatchUtil.latch(()->{
            helloService.sayHello(currentTimeMills);
        });
    }
}
