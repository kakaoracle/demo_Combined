package com.wechat.localtest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 按钮,用来发送给微信
 * @author: DeZhao Chen
 * @create: 2019-10-28 22:19
 **/
@Data
public class Button {
    private List<AbstractButton> button = new ArrayList<>();
}
