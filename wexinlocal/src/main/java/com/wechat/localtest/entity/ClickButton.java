package com.wechat.localtest.entity;

import com.wechat.localtest.constant.CommonConstant;
import lombok.Data;

/**
 * @description: 点击按钮
 * @author: DeZhao Chen
 * @create: 2019-10-19 19:50
 **/
@Data
public class ClickButton extends AbstractButton {
    private String key;
    private String type = CommonConstant.CLICK;

    public ClickButton(String name,String key) {
        super(name);
        this.key = key;
    }
}
