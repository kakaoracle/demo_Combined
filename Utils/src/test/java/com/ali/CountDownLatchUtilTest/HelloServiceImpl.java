package com.ali.CountDownLatchUtilTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloServiceImpl implements HelloService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    @Transactional
    public void sayHello(long timeMillis) {
        long time = System.currentTimeMillis() - timeMillis;
        if (time > 5000){
            log.warn("time:{}",time);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
