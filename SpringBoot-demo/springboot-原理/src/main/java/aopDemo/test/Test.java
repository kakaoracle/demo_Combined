package aopDemo.test;

import aopDemo.config.Appconfig;
import aopDemo.dao.IndexDaoImpl;
import aopDemo.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: kakaoracle
 * @create: 2019-04-07 08:55
 **/
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        IndexDaoImpl dao = (IndexDaoImpl) annotationConfigApplicationContext.getBean("dao");
        //测试能否输出"dao---query"
        dao.query();//----->能够正确输出
    }
}
