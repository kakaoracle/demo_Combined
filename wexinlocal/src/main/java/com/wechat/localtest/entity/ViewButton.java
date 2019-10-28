package com.wechat.localtest.entity;

import lombok.Data;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-10-19 21:03
 **/
@Data
public class ViewButton {
    private String type = "view";
    private  String url;

    public ViewButton(String type, String url) {
        this.type = type;
        this.url = url;
    }
}
