package com.iss.util;

import com.iss.Constant.Constants;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
/**
 *检验工具类
 */
public class LoginCheck {

    /**
     * 首先是校验Cookie
     */
    public static boolean checkCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if( cookies == null){
            return false;
        }
        for (Cookie cookie : cookies) {
            if(Constants.COOKIE_NAME.equals(cookie.getName()) &&
               Constants.COOKIE_VALUE.equals(cookie.getValue())){
                return true;
            }
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
