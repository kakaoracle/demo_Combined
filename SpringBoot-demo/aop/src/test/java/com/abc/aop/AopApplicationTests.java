package com.abc.aop;

import com.abc.aop.service.CheckNullService;
import com.abc.aop.vo.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.Date;

@SpringBootTest
class AopApplicationTests {

    @Autowired
    private CheckNullService service;

    // param为空,抛出错误
    @Test
    public void test() {
        Param param = new Param();
        service.test(null, param);
    }

    // param实例有值,不抛出错误
    @Test
    public void test1() {
        Param param = new Param();
        param.setProperty3("123");
        try {
            Field property3 = param.getClass().getDeclaredField("property3");
            property3.setAccessible(true);
            System.out.println("===property3: "+property3.get(param));
        } catch (Exception e) {
            System.out.println("=====这是错误的");
            e.printStackTrace();
        }
        service.test(null, param);
    }


}
