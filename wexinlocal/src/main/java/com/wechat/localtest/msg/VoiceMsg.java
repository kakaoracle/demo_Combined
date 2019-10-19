package com.wechat.localtest.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Map;

/**
 * @description: 语音消息
 * @author: DeZhao Chen
 * @create: 2019-10-18 18:56
 **/
@Data
@Log
@XStreamAlias("xml")
public class VoiceMsg extends BaseMsg {
    private  String MediaId;
    public VoiceMsg(Map<String,String> requestMap,String mediaId){
        super(requestMap);
        this.setMsgType("voice");
        this.MediaId = mediaId;
    }
}
