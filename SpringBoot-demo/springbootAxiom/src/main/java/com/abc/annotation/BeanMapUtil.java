package com.abc.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description: bean转化为map的方法
 * @author: DeZhao Chen
 * @create: 2019-07-11 09:50
 **/
public class BeanMapUtil {
    public static Map<String,Object> BeanToMap(Object bean,Map<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        if (map == null){
            map = new HashMap<String,Object>();
        }
        Method[] methods = bean.getClass().getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(CdzGet.class)){
                CdzGet gm = method.getAnnotation(CdzGet.class);
                String fieldName = gm.uuidTest();
                String uuidTest = gm.uuidTest();
                uuidTest = String.valueOf(UUID.randomUUID());
                Object fieldValue = method.invoke(bean);
                map.put(fieldName,fieldValue);
            }
        }
        return map;
    }



}
