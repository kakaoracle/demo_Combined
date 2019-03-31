package com.iss.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.iss.Constant.Constants;
import com.iss.util.LoginCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * SSO登录器,通过用户名与密码登录来设置cookie
 */
@Controller
//@RequestMapping("/sso")
public class LoginController {
    
    /**
     * 处理用户登录请求
     */
    @PostMapping("/doLogin")
    public ModelAndView doLogin(String username,String password,
            String gotoUrl,HttpServletResponse response){
        ModelAndView mv = new ModelAndView("login_fail");
        // 校验用户名和密码
        boolean ok = LoginCheck.checkLogin(username, password);
        // 判断是否登录成功
        if(ok){
            Cookie cookie = new Cookie(Constants.COOKIE_NAME,Constants.COOKIE_VALUE);
            // cookie路径设置为/则表示为顶级域名，其下所有应用都是可见的
            cookie.setPath("/");
            // 添加Cookie,没有设置expire则表示关闭浏览器cookie就清空
            response.addCookie(cookie);
            mv.setViewName("redirect:"+gotoUrl);
        }
        return mv;
    }
    
    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}
