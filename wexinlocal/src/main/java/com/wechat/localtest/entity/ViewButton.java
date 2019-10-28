package com.wechat.localtest.entity;

import lombok.Data;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-10-19 21:03
 **/
@Data
public class ViewButton extends AbstractButton {
    private String type = "view";
    private  String url;

    public ViewButton(String name, String url) {
        super(name);
        this.type = type;
        this.url = url;
    }
}
