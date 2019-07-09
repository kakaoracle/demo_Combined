package inject_withoutAnno;

import com.abc.injectWithoutAnno.constant.ParseType;
import com.abc.injectWithoutAnno.context.ApplicationContext;
import com.abc.injectWithoutAnno.service.DemoService;
import org.junit.Test;

/**
 * @description: 依赖注入测试
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:42
 **/
public class InjectTest {
    @Test
    //injectWithoutAnno
    public void testInject(){
        ApplicationContext applicationContext = new ApplicationContext("application-context-inject.xml", ParseType.XML_PARSER);
        DemoService demoService = (DemoService) applicationContext.getBean("demoService");
        demoService.greet();
    }
}
