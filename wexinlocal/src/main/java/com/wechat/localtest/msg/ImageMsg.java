package com.wechat.localtest.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Map;

/**
 * @description: 图片消息
 * @author: DeZhao Chen
 * @create: 2019-10-18 18:54
 **/
@Log
@Data
@XStreamAlias("xml")
public class ImageMsg extends BaseMsg {
    private String MediaId;
    public ImageMsg(Map<String,String> requestMap,String mediaId){
        super(requestMap);
        this.setMsgType("image");
        this.MediaId = mediaId;
    }
}
