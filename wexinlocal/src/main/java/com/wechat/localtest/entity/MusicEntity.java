package com.wechat.localtest.entity;

import lombok.Data;

/**
 * @description: 音乐消息二级单元
 * @author: DeZhao Chen
 * @create: 2019-10-18 19:12
 **/
@Data
public class MusicEntity {
    private String title;
    private String description;
    private String musicURL;
    private String hQMusicUrl;
    private String thumbMediaId;
    public MusicEntity(String title, String description, String musicURL, String hQMusicUrl, String thumbMediaId) {
        super();
        this.title = title;
        this.description = description;
        this.musicURL = musicURL;
        this.hQMusicUrl = hQMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }
}
