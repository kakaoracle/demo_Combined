package 依赖注入;

import com.abc.依赖注入_含注解与非注解.constant.ParseType;
import com.abc.依赖注入_含注解与非注解.context.ApplicationContext;
import com.abc.依赖注入_含注解与非注解.service.DemoService;
import org.junit.Test;

/**
 * @description: 依赖注入测试
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:42
 **/
public class InjectTest {

    @Test
    //依赖注入_含注解与非注解
    public void testInject(){
        ApplicationContext applicationContext = new ApplicationContext("application-context-inject.xml", ParseType.XML_PARSER);
        DemoService demoService = (DemoService) applicationContext.getBean("demoService");
        demoService.greet();
        demoService.lighting();
    }


}
