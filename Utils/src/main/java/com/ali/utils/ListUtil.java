package com.ali.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;

/**
 * @description: 集合的复制操作
 * @author: DeZhao Chen
 * @create: 2019-09-19 12:01
 **/
public class ListUtil {

    public static void copyList(List srcList, List targetList,Class targetClass) {
        try {
            Object data = tarClass.newInstance();
            if ((!Objects.isNull(srcList)) && (!Objects.isNull(targetList))) {
                srcList.forEach(item -> {
                    BeanUtils.copyProperties(item, data);
                    targetList.add(data);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
