package com.iss.controller;

import javax.servlet.http.HttpServletRequest;

import com.iss.util.LoginCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *第一个页面
 */
@RestController
public class DemoOneController {
    public static final Logger log = LoggerFactory.getLogger(DemoOneController.class);
    @RequestMapping("/demo1")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        //如果检查cookie正确,则跳转到静态资源
        if (LoginCheck.checkCookie(request)) {
            mv.setViewName("demo1");
            return mv;
        }
        //传递到html中的gotoUrl变量值为/demo01
        mv.addObject("gotoUrl", "/demo1");
        //转发到登录页面,之前配置了省略.html
        mv.setViewName("login");
        log.info("***mv:"+mv.toString());
        return mv;
    }
}
