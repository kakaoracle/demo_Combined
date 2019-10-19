package com.wechat.localtest.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wechat.localtest.constant.MsgType;
import com.wechat.localtest.entity.ArticleEntity;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Map;

/**
 * @description: 图文消息
 * @author: DeZhao Chen
 * @create: 2019-10-19 14:53
 **/
@Data
@Log
@XStreamAlias("xml")
public class NewsMsg extends BaseMsg{
    private String ArticleCount;
    private List<ArticleEntity> Articles;

    public NewsMsg(Map<String,String> requestMap, List<ArticleEntity> articles) {
        super(requestMap);
        setMsgType(com.wechat.localtest.constant.MsgType.NEWS);
        ArticleCount = articles.size()+"";
        Articles = articles;
    }
}




























