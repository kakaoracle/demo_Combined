package com.wechat.localtest.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @description: 图文中的文
 * @author: DeZhao Chen
 * @create: 2019-10-18 19:20
 **/
@Data
@XStreamAlias("item")
public class ArticleEntity {
    private String Title;
    private String Description;
    private String PicUrl;
    private String Url;

    public ArticleEntity(String title, String description, String picUrl, String url) {
        Title = title;
        Description = description;
        PicUrl = picUrl;
        Url = url;
    }
}
