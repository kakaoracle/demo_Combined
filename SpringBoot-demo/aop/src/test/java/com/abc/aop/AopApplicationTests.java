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
        service.test(null, param);
    }

    //实例->实例class->实例class中的变量名->变量值
    @Test
    public void test2() throws Exception {
        Param param = new Param();
        param.setProperty3("alibaba");
        Class<?> aClass = param.getClass();
        Field property3 = aClass.getField("property3");
        System.out.println("===通过变量名获取的值:"+property3.get(param));//获取成功
    }

    @Test
    public void test3() {
        Param param = new Param();
        param.setProperty3("alibaba");

    }



}
