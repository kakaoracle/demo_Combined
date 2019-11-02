package com.wechat.localtest.entity;

import lombok.Data;

/**
 * @description: 所有按钮的name属性抽象出来的父类
 * @author: DeZhao Chen
 * @create: 2019-10-19 20:59
 **/
@Data
public class AbstractButton {
    private String name;
    public AbstractButton(String name){
        //super();
        this.name=name;
    }
}
