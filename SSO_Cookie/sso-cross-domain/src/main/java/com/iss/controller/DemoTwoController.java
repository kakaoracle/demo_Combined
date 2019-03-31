package com.iss.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iss.constants.CommonConstant;
import com.iss.util.HttpUtils;
import com.iss.util.MsgResult;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/b")
public class DemoTwoController {
    public static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/demo2")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        
        //校验cookie是否为空
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            //校验cookie是否存在
            for(Cookie cookie : cookies){
                if("ssocookie".equals(cookie.getName())){
                 // 封装请求参数
                    Map<String,String> param = new HashMap<String,String>(16);
                    param.put("cookieName", cookie.getName());
                    param.put("cookieValue", cookie.getValue());
                    // 向校验服务器发送校验请求
                    String url = "http://www.x.com/sso/checkCookie";
                    MsgResult msgResult = HttpUtils.doGet(url, param);
                    log.info("httpResult:"+msgResult.toString());
                    // 校验通过
                    if (CommonConstant.HTTP_CODE_OK == msgResult.getCode()){
                        mv.setViewName("demo2");
                        return mv;
                    }
                }
            }
        }
        // 登录失败重新登录
        mv.addObject("contextPath",request.getContextPath());
        mv.addObject("path","b");
        mv.addObject("gotoUrl", "http://www.b.com/b/demo2");
        mv.setViewName("login");
        return mv;
    }
    
    /**
     * 用户登录
     * @param param
     * @return
     */
    @PostMapping(value="/doLogin")
    public MsgResult doLogin(@RequestParam Map<String,String> param){
        // 向校验服务器发送校验请求
        String url = "http://www.x.com/sso/doLogin";
        MsgResult msgResult = HttpUtils.doGet(url, param);
        System.out.println("SSO服务器响应消息："+msgResult.toString());
        return msgResult;
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
}
