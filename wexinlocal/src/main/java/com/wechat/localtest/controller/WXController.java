package com.wechat.localtest.controller;

import com.wechat.localtest.service.WXService;
import com.wechat.localtest.util.MsgUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-10-17 16:59
 **/
@Log
@RestController
@RequestMapping("/localwx")
public class WXController extends HttpServlet {
    @Autowired
    WXService WXService;


    @GetMapping("/test")
    public String check(@RequestParam("signature")String signature,
                        @RequestParam("timestamp") String timestamp,
                        @RequestParam("nonce") String nonce,
                        @RequestParam("echostr") String echostr){
        //校验证签名
        if(WXService.check(timestamp,nonce,signature)) {
            System.out.println("接入成功");
            return echostr;
        }else {
            log.info("接入失败");
            return null;
        }
    }

    @PostMapping("/test")
    public String post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> msgMap = MsgUtil.xml2Map(request);
        log.info("-----request内容: "+msgMap);
        String xmlStr = WXService.createXmlStr(msgMap);
        log.info("-----response内容: "+xmlStr);
        return xmlStr;
    }



}
