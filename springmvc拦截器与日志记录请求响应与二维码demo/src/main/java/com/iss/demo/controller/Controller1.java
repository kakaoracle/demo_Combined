package com.iss.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {
    @RequestMapping("/hello")
    //string与int也相当于进行了校验,必须有对应的参数,否则就没有页面出现
    public String hello(String name,int state){
        return "name: " + name + "---" +state;
    }
}
