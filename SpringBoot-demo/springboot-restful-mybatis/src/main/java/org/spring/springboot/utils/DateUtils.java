package org.spring.springboot.utils;


import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 日期与字符串相关的转换
 * @author: cdz
 * @create: 2019-02-23 23:01
 **/
public class DateUtils {
    /**
     * String转换成Date
     *
     * @param dateString
     * @return
     */
    public static Date parseStringToDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        if (!StringUtils.isBlank(dateString)) {
            try {
                date = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                return date;
            }
        } else {
            return null;
        }
    }

    /**
     * String转换成Date,可自定义字符串格式
     *
     * @param dateString
     * @return
     */
    public static Date parseStringToDate(String dateString, String formatString) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        Date date = new Date();
        if (!StringUtils.isBlank(dateString)) {
            try {
                date = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                return date;
            }
        } else {
            return null;
        }
    }


    /**
     * Date转换为String
     *
     * @param date
     * @return
     */
    public static String parseDateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (null != date) {
            String str = format.format(date);
            return str;
        } else {
            return null;
        }

    }

    /**
     * Date转换为String,可自定义形式
     *
     * @param date
     * @param formatString
     * @return
     */
    public static String parseDateToString(Date date, String formatString) {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        if (null != date) {
            String str = format.format(date);
            return str;
        } else {
            return null;
        }

    }
}
