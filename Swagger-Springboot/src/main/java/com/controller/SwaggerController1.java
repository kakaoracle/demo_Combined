package com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "tag",description = "用户相关接口文档")//tags是类名,默认为下方类名,description是紧接类名之后的描述
public class SwaggerController1 {
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户", notes = "查询用户信息")//value是标签未点开时显示的方法的用途,note是点开后第一项的描述
    public String query(
           @ApiParam(name = "userName1",required = true,value = "用户昵称")//apiparam的name是ui界面显示的名字,value是界面上的描述
           @RequestParam(name = "userName",required = true)
           String userName ) {
        return ">>>enter query";
    }

}
