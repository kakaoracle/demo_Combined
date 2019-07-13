package com.abc.annotation;

import java.lang.reflect.Field;
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
    public static Map<String,Object> BeanToMap(Object bean) throws InvocationTargetException, IllegalAccessException {
        Map map = new HashMap<String,Object>();
        //获取字段名
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields){
            if (field.isAnnotationPresent(CdzGet.class)){
                CdzGet gf = field.getAnnotation(CdzGet.class);
                String fieldName = field.getName();
                String fieldVal = gf.uuidTest();
                fieldVal = String.valueOf(UUID.randomUUID());
                map.put(fieldName,fieldVal);
            }
        }

        //获取方法名
        /*Method[] methods = bean.getClass().getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(CdzGet.class)){
                CdzGet gm = method.getAnnotation(CdzGet.class);
                String fieldName = method.getName();
                String fieldVal = gm.uuidTest();
                fieldVal = String.valueOf(UUID.randomUUID());
                map.put(fieldName,fieldVal);
            }
        }*/
        return map;
    }



}
