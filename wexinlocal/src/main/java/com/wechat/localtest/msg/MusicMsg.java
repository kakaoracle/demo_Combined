package com.wechat.localtest.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.localtest.entity.MusicEntity;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.Map;

/**
 * @description: 音乐消息
 * @author: DeZhao Chen
 * @create: 2019-10-18 19:07
 **/
@Data
@Log
@XStreamAlias("xml")
public class MusicMsg extends BaseMsg{
    private  MusicEntity musicEntity;

    public MusicMsg(Map<String,String> requestmap, MusicEntity musicEntity){
        super(requestmap);
        this.setMsgType("music");
        this.musicEntity = musicEntity;
    }


}
