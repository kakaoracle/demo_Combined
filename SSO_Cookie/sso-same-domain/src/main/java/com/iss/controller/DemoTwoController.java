package com.iss.controller;

import javax.servlet.http.HttpServletRequest;

import com.iss.util.LoginCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DemoTwoController {

    @RequestMapping("/demo2")
    public ModelAndView main(HttpServletRequest request) {
        
        ModelAndView mv = new ModelAndView();
        //如果检查cookie正确,则跳转到静态资源
        if (LoginCheck.checkCookie(request)) {
            mv.setViewName("demo2");
            return mv;
        }
        mv.addObject("gotoUrl", "/demo2");
        mv.setViewName("login");
        return mv;
    }
}
