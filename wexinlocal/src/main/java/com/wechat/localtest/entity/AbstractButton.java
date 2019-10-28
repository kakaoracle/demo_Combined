package com.wechat.localtest.entity;

import lombok.Data;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-10-19 20:59
 **/
@Data
public class AbstractButton {
    private String name;
    public AbstractButton(String name){
        super();
        this.name=name;
    }
}
