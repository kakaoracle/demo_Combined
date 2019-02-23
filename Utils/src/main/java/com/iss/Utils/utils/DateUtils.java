package com.iss.Utils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 日期与字符串相关的转换
 * @author: cWX597167
 * @create: 2019-02-23 23:01
 **/
public class DateUtils {
    /**
     * String转换成Date
     * @param dateString
     * @return
     */
    public static Date parseStringToDate(String dateString){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        Date date = new Date();
        try {
            date = sdf.parse( dateString );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * String转换成Date,可自定义字符串格式
     * @param dateString
     * @return
     */
    public static  Date parseStringToDate(String dateString,String formatString){
        SimpleDateFormat sdf =  new  SimpleDateFormat( formatString );
        Date date = new Date();
        try {
            date = sdf.parse( dateString );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date转换为String
     * @param date
     * @return
     */
    public static String parseDateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * Date转换为String,可自定义形式
     * @param date
     * @param formatString
     * @return
     */
    public static String parseDateToString(Date date,String formatString){
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        String str = format.format(date);
        return str;
    }
}
