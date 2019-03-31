package com.iss.util;


import com.iss.Constant.Constants;
import com.sun.org.apache.bcel.internal.classfile.ConstantString;

public class LoginCheck {
    /**
     * 首先是校验Cookie
     */
    public static boolean checkCookie(String cookieName,String cookieValue) {
        if (cookieName == null || cookieName=="") {
            return false;
        }
        if (cookieValue == null || cookieValue=="") {
            return false;
        }
        if (Constants.COOKIE_NAME.equals(cookieName) && Constants.COOKIE_VALUE.equals(cookieValue)) {
            return true;
        }
        return false;
    }
    
    /**
     * 检查发现没有cookie再检验用户名和密码以设置cookie
     */
    public static boolean checkLogin(String username, String password) {
        if (Constants.USERNAME.equalsIgnoreCase(username) && Constants.PASSWORD.equalsIgnoreCase(password)) {
            return true;
        }
        return false;
    }



}
