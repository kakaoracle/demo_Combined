package com.iss.FileResources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @RequestMapping("/contest")
    public String testcon(){
        System.out.println("enter contest");
        return "enter contest";
    }
}
