package com.abc.sessiondemo.controller;

import com.abc.sessiondemo.Util.MsgResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 示例
 * @author: DeZhao Chen
 * @create: 2019-09-29 17:07
 **/
@RestController
@Log
public class UserController {
    @ApiOperation("登录")
    @PostMapping(value = "/login")
    public MsgResult login(
            @ApiParam(value = "userName",required = true)@RequestParam("userName") String userName,
            @ApiParam(value = "password",required = true)@RequestParam("password") String password,
            HttpServletResponse response,
            HttpServletRequest request){
        MsgResult msgResult = new MsgResult();

        String token = "";
        //登录成功,写入token
        /*if(userInfoVo != null){
            TokenVo tokenVo = new TokenVo();
            try {
                tokenVo.setPassword(userInfoVo.getPassword());
                tokenVo.setUserName(userInfoVo.getUserName());
                tokenVo.setUserId(userInfoVo.getUserID());
                token = JWT.sign(tokenVo,1000*60*60*24*90L);//90天
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("userName",userInfoVo.getUserName());
                    jsonObject.put("userId",userInfoVo.getUserID());
                    jsonObject.put("token",token);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return msgResult.build(600,"login success",jsonObject);
            }*/
            /*request.getSession(true);
            request.getSession().setAttribute(WebSecurityConfig.SESSION_KEY, userInfoVo.userID);//将用户名存入该用户的session 中
            response.addCookie(new Cookie("JSSESIONID",request.getSession().getId()));
            log.info("登录密码正确，已写入sessionid"+request.getSession().getAttribute(WebSecurityConfig.SESSION_KEY)+",sessionId"+request.getSession().getId());
            return msgResult.build(600,"login success",userInfoVo);
        }else{
            log.info("登录密码不正确");
        }*/
        return null;//
    }
}
