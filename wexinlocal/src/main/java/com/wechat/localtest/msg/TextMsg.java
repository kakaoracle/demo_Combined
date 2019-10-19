package com.wechat.localtest.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @description: 文本消息
 * @author: DeZhao Chen
 * @create: 2019-10-18 18:30
 **/
@Data
@XStreamAlias("xml")
public class TextMsg extends  BaseMsg {
    private String Content;
    public TextMsg(Map<String,String> requestMap,String content){
        super(requestMap);
        this.setMsgType("text");
        this.Content = content;
    }



}
