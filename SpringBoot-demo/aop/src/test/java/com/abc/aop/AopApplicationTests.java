package com.abc.aop;

import com.abc.aop.service.CheckNullService;
import com.abc.aop.vo.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopApplicationTests {

    @Autowired
    private CheckNullService service;

    @Test
    public void test() {

        Param param = new Param();
        service.test(null, param);

    }

}
