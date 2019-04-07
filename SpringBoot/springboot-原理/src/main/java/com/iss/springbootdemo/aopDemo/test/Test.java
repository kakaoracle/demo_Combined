package com.iss.springbootdemo.aopDemo.test;

import com.iss.springbootdemo.aopDemo.config.Appconfig;
import com.iss.springbootdemo.aopDemo.dao.IndexDao;
import com.iss.springbootdemo.aopDemo.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: cWX597167
 * @create: 2019-04-07 08:55
 **/
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        IndexDaoImpl dao = (IndexDaoImpl) annotationConfigApplicationContext.getBean(IndexDao.class);
        //测试能否输出"dao---query"
        dao.query();
    }
}
