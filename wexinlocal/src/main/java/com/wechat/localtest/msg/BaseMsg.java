package com.wechat.localtest.msg;

import lombok.Data;

import java.util.Map;

/**
 * @description: 基础消息
 * @author: DeZhao Chen
 * @create: 2019-10-18 18:28
 **/
@Data
public class BaseMsg {
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;

    public BaseMsg(Map<String,String> requestMap){
        //发送方与生成方与接收的调换
        this.ToUserName= requestMap.get("FromUserName");
        this.FromUserName = requestMap.get("ToUserName");
        this.CreateTime = String.valueOf(System.currentTimeMillis()/1000);
    }

}
