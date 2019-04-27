import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @description: 测试类
 * @author: cWX597167
 * @create: 2019-02-02 15:18
 **/
@Slf4j
public class TemTest {

    @Test
    public void testLog(){
        String is_null = null;

        try {
            System.out.println(is_null.toString());
        } catch (Exception e) {
            e.printStackTrace();
            //printStackTrace没有返回值,因此打印日志时两句还是都存在的好
            log.info("出错信息:"+e);
        }
    }
}
