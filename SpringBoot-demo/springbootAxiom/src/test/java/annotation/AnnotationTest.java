package annotation;

import com.abc.annotation.MapBeanUtil;
import com.abc.annotation.bean.User;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @description: 注解测试
 * @author: DeZhao Chen
 * @create: 2019-07-11 10:16
 **/
public class AnnotationTest {
    @Test
    public void test1() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setMarried(true);
        user.setName("jackMa");
        user.setFriends(new ArrayList<User>());

        Map<String, Object> map = MapBeanUtil.BeanToMap(user, null);
        System.out.println(map.get("name"));
        /*User u = (User) MapBeanUtil.MapToBean(map, new User());
        System.out.println(u.getName());*/
    }
}
