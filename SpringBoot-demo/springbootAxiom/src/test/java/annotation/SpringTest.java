package annotation;

import com.abc.annotation.bean.Info;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringTest {
    @Test
    public void test1(){
        Info info = new Info();
        System.out.println(info.getClassName());
    }
}
