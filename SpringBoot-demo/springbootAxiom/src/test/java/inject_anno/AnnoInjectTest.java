package inject_anno;

import com.abc.injectAnno.constant.ParseType;
import com.abc.injectAnno.context.ApplicationContext;
import com.abc.injectAnno.service.DemoService;
import org.junit.Test;

/**
 * @description: 注解依赖注入
 * @author: DeZhao Chen
 * @create: 2019-07-09 14:22
 **/
public class AnnoInjectTest {
    @Test
    //injectWithoutAnno
    public void testAnnoInject(){
        ApplicationContext applicationContext = new ApplicationContext("application-context-anno-inject.xml", ParseType.XML_PARSER);
        DemoService demoService = (DemoService) applicationContext.getBean("demoService");
        demoService.greet();
        demoService.lighting();
    }
}
