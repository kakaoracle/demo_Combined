package com.abc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name,@RequestParam("state") int state){
        return "name: " + name + "---state: " +state;
    }
}
