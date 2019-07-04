package 类的加载和实例化;

import com.abc.类的加载和实例化.constant.ParseType;
import com.abc.类的加载和实例化.context.ApplicationContext;
import com.abc.类的加载和实例化.dao.DemoDao;
import org.junit.Test;

import java.net.URL;

/**
 * @description: 类的加载和实例化测试
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:42
 **/
public class BeanTest {

    @Test
    public void test01(){
        ApplicationContext xmlApplicationContext = new ApplicationContext("application-context-getbean.xml", ParseType.XML_PARSER);
        DemoDao xmlDemoDao = (DemoDao) xmlApplicationContext.getBean("demoDao");
        xmlDemoDao.greet();
    }

    @Test
    public void testClassLoader(){
        //用getResource是为了避免硬编码(直接写磁盘位置)
        //getClassLoader().getResource("")和下面的getResource("/")是相同的,,一般用下面两种就够了
        URL resource = BeanTest.class.getClassLoader().getResource("");
        //没有getClassLoader.getresource("/")这种写法
        URL resource1 = BeanTest.class.getClassLoader().getResource("/");
        //getresource是获取当前文件(编译成的class文件)所在的物理路径,"/"是项目的根目录,""是此类的路径
        URL resource2= BeanTest.class.getResource("");
        URL resource3 = BeanTest.class.getResource("/");
        System.out.println(resource);
        System.out.println(resource1);
        System.out.println(resource2);
        System.out.println(resource3);
        System.out.println(BeanTest.class.getResource("/"));
    }


}
