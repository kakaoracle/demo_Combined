package com.ali.utils;

/**
 * @description: 常用工具类
 * ESCAPE
 * @author:
 * @create: 2019-02-23 19:11
 **/
public class CommonUtils {




    /**
     * 查询sql前转义特殊字符为普通字符
     * @param srcString
     * @return
     */
    public static String escapeCharacter(String srcString){
        if (null != srcString){
            srcString = srcString.replace("%","\\%");
            srcString = srcString.replace("_","\\_");
            srcString = srcString.replace("[","\\[");
            srcString = srcString.replace("]","\\]");
        }
        return srcString;
    }







}
