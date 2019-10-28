package com.wechat.localtest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 菜单栏按钮
 * @author: DeZhao Chen
 * @create: 2019-10-19 19:47
 **/
@Data
public class BaseButtonEntity {
    private List<AbstractButton> button = new ArrayList<>();

}
