package com.iss.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iss.constants.CommonConstant;
import com.iss.util.HttpUtils;
import com.iss.util.MsgResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/a")
public class DemoOneController {
    public static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/demo1")
    public ModelAndView demo1(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        log.info("/a/demo1的request:"+request.toString());
        //校验cookie是否为空
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            //名称为ssocookie存在,且值正确,则通过
            for(Cookie cookie : cookies){
                if("ssocookie".equals(cookie.getName())){
                    // 封装请求参数
                    Map<String,String> param = new HashMap<String,String>(16);
                    param.put("cookieName", cookie.getName());
                    param.put("cookieValue", cookie.getValue());
                    // 向校验服务器发送校验请求
                    String url = "http://www.x.com/sso/checkCookie";
                    MsgResult msgResult = HttpUtils.doGet(url, param);
                    // 校验cookie通过
                    if(200 == msgResult.getCode()){
                        mv.setViewName("/WEB-INF/demo1.html");
                        return mv;
                    }
                }
            }
        }
        //cookie为空,需要进行登录,之后再保存cookie
        String path = request.getContextPath();
        mv.addObject("contextPath",path);
        //设置path这个关键字目的是为了设置cookie
        mv.addObject("path","a");
        //gotoUrl是前台页面设置的值,前台请求的话,不能全部请求给x.com,这样就无法给a设置cookie了,因此需要动态设置
        mv.addObject("gotoUrl", "http://www.a.com/a/demo1");
        mv.setViewName("login");
        return mv;
    }
    
    /**
     * 用户登录
     * @param param
     * @return
     */
    @PostMapping(value="/doLogin")
    public ModelAndView doLogin(HttpServletRequest request,@RequestParam Map<String,String> param){
        // 向校验服务器发送校验请求
        ModelAndView mv = new ModelAndView();
        String url = "http://www.x.com/sso/doLogin";
        MsgResult msgResult= HttpUtils.doGet(url, param);
        System.out.println("SSO服务器响应消息："+msgResult.toString());
        if (msgResult.getCode() == CommonConstant.HTTP_CODE_OK){
            String path = request.getContextPath();
            mv.addObject("contextPath",path);
            mv.addObject("path","a");
            mv.setViewName("demo1");

        }
        return mv;

    }
    
    /**
     * 向当前域添加cookie
     * @param cookieName
     * @param cookieValue
     * @param response
     */
    @RequestMapping(value="/addCookie")
    public void addCookie(String cookieName,String cookieValue,HttpServletResponse response){
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @GetMapping(value="/ttt")
    public ModelAndView ttt(){
        ModelAndView modelAndView = new ModelAndView("redirect:login");
        /*modelAndView.setViewName("demo1");
        log.info("mv:"+modelAndView.toString());*/
        return modelAndView;
    }


}
