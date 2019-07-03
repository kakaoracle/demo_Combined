package 类的加载和实例化;

import com.abc.类的加载和实例化.constant.ParseType;
import com.abc.类的加载和实例化.context.ApplicationContext;
import com.abc.类的加载和实例化.dao.DemoDao;

/**
 * @description: 类的加载和实例化测试
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:42
 **/
public class BeanTest {

    public void test01(){
        ApplicationContext xmlApplicationContext = new ApplicationContext("application-context-getbean.xml", ParseType.XML_PARSER);
        DemoDao xmlDemoDao = (DemoDao) xmlApplicationContext.getBean("demoDao");
        xmlDemoDao.greet();
    }
}
