package com.wechat.localtest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二级菜单
 * @author: DeZhao Chen
 * @create: 2019-10-19 21:09
 **/
@Data
public class SubButton extends  AbstractButton {
    private List<AbstractButton> sub_button = new ArrayList<>();
    public SubButton(String name) {
        super(name);
    }
}
