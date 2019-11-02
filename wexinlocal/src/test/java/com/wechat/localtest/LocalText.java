package com.wechat.localtest;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.wechat.localtest.msg.TextMsg;
import com.wechat.localtest.util.HttpUtils;
import com.wechat.localtest.util.MsgResult;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @description: 不启动工程测试
 * @author: DeZhao Chen
 * @create: 2019-10-18 19:25
 **/
@Log
public class LocalText {


    @Test
    public void testXstream(){
        HashMap<String, String> map = new HashMap<>();
        map.put("ToUserName","123");
        map.put("FromUserName","456");
        map.put("MsgTye","text");
        TextMsg msg = new TextMsg(map, "hello");
        XStream xStream = new XStream();
        xStream.processAnnotations(TextMsg.class);
        String xmlStr = xStream.toXML(msg);
        System.out.println(xmlStr);
        //log.info(xmlStr);
    }





}
