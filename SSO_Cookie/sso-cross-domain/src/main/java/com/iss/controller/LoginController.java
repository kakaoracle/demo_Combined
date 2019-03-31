package com.iss.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iss.constants.CommonConstant;
import com.iss.util.MsgResult;
import com.iss.util.RespMessage;
import com.iss.util.LoginCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SSO登录控制器
 *
 */
@Controller
@RequestMapping("/sso")
public class LoginController {
    public static final Logger log = LoggerFactory.getLogger(LoginController.class);
    /**
     * 校验用户信息
     * @return
     */
    @GetMapping("/doLogin")
    @ResponseBody
    public MsgResult doLogin(String username, String password) {
        log.info("***doLogin_username:"+username+",password:"+password);

        // 校验用户名和密码
        boolean ok = LoginCheck.checkLogin(username,password);
        // 判断是否登录成功
        if (ok) {
            log.info("***登录验证成功");
            List<Map<String,String>> targetCookies = new ArrayList<Map<String,String>>();
            
            // 向www.a.com服务器发送增加cookie
            Map<String,String> targetCookiea = new HashMap<String,String>(16);
            String urla = "http://www.a.com/a/addCookie";
            targetCookiea.put("targetUrl", urla);
            targetCookiea.put("cookieName", LoginCheck.COOKIE_NAME);
            targetCookiea.put("cookieValue",LoginCheck.COOKIE_VALUE);
            
            // 向www.b.com服务器发送增加cookie
            Map<String,String> targetCookieb = new HashMap<String,String>(16);
            String urlb = "http://www.b.com/b/addCookie";
            targetCookieb.put("targetUrl", urlb);
            targetCookieb.put("cookieName", LoginCheck.COOKIE_NAME);
            targetCookieb.put("cookieValue", LoginCheck.COOKIE_VALUE);

            targetCookies.add(targetCookiea);
            targetCookies.add(targetCookieb);
            
            Map<String,Object> args = new HashMap<String,Object>(16);
            args.put("targetCookies", targetCookies);
            //
            log.info("***LoginController的结果:"+MsgResult.ok().toString());
            return MsgResult.ok();
        }else {
            return MsgResult.build(CommonConstant.HTTP_Code_NO_CONTENT,CommonConstant.HTTP_STATUS_NO_CONTENT);
        }

    }
    
    /**
     * 校验cookie
     * @param cookieName
     * @param cookieValue
     * @return
     */
    @GetMapping("/checkCookie")
    @ResponseBody
    public MsgResult checkCookie(String cookieName,String cookieValue){
        log.info("**checkCookie方法接收到的cookieName与cookieValue为:"+cookieName+","+cookieValue);
        RespMessage result = new RespMessage();
        result.setRespCode("500");
        result.setRespMsg("CookieName或CookieValue无效");
        boolean isOk = LoginCheck.checkCookie(cookieName, cookieValue);
        if(isOk) {
            return MsgResult.ok();
        }else {
            return MsgResult.build(CommonConstant.HTTP_Code_NO_CONTENT,"CookieName或CookieValue无效");
        }
    }
}
