package com.wechat.localtest.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Map;

/**
 * @description: 视频消息
 * @author: DeZhao Chen
 * @create: 2019-10-18 19:04
 **/
@Data
@Log
@XStreamAlias("xml")
public class VideoMsg extends BaseMsg {
    private  String MediaId;
    private String Title;
    private String Description;

    public VideoMsg(Map<String,String> requestMap,String mediaId,String title,String description){
        super(requestMap);
        this.setMsgType("video");
        this.MediaId = mediaId;
        this.Title = title;
        this.Description = description;
    }
}
