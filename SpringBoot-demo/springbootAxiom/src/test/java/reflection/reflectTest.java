package reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-07-06 19:53
 **/
public class reflectTest {

    @Test
    //测试invoke,方法.invoke(实例,"参数值");
    public void invokeMethodTest() throws Exception {
        //创建类
        Class<?> aClass = Class.forName("com.abc.reflection.PersonImpl");
        //创建实例
        Object person = aClass.newInstance();
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        //打破私有属性检查
        setName.setAccessible(true);
        setName.invoke(person, "jack");
        //获取name字段
        Field nameField = aClass.getDeclaredField("name");
        nameField.setAccessible(true);
        String name_ = (String) nameField.get(person);
        System.out.println("name: "+name_);

    }
}
