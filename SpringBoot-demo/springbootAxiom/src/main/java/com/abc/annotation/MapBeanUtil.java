package com.abc.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description: map和bean直接相互转化方法
 * @author: DeZhao Chen
 * @create: 2019-07-11 09:50
 **/
public class MapBeanUtil {
    public static  Object MapToBean(Map<String,Object> map,Object obj) throws InvocationTargetException, IllegalAccessException {
        if (obj == null) {
            return null;
        }
        Method[] methods = obj.getClass().getMethods();
        for (Method method: methods){
            if (method.isAnnotationPresent(SetMethod.class)){
                SetMethod sm = method.getAnnotation(SetMethod.class);
                String fieldName = sm.value();
                Object fieldVal = map.get(fieldName);
                method.invoke(obj,fieldVal);
            }
        }
        return obj;
    }

    public static Map<String,Object> BeanToMap(Object bean,Map<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        if (map == null){
            map = new HashMap<String,Object>();
        }
        Method[] methods = bean.getClass().getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(GetMethod.class)){
                GetMethod gm = method.getAnnotation(GetMethod.class);
                String fieldName = gm.value();
                String uuidTest = gm.uuidTest();
                uuidTest = String.valueOf(UUID.randomUUID());
                Object fieldValue = method.invoke(bean);
                map.put(fieldName,fieldValue);
            }
        }
        return map;
    }



}
