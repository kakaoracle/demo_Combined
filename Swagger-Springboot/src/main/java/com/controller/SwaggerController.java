package com.controller;

import com.vo.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户相关接口文档")//tags,用来分组,一般同一个类为一组,tag必填
public class SwaggerController {
    @GetMapping("/getQuery")
    @ApiOperation("GET查询用户")
    public String getQuery(
           @ApiParam(value = "用户昵称",required = true)
           @RequestParam(name = "userName",required = true)
           String userName ) {
        return "******enter getQuery";
    }
    @ApiOperation("POST查询用户")
    @PostMapping("/postQuery")
    public String postQuery(@ApiParam("人员信息")@RequestBody Person person){
        return "******enter postQuery";
    }

}
