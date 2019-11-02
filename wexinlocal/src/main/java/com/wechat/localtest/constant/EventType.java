package com.wechat.localtest.constant;

import lombok.Data;

/**
 * @description: 点击按键是事件,关注取消也是事件,MsgType是event,同时Event下细分种类
 * @author: DeZhao Chen
 * @create: 2019-11-02 14:03
 **/
@Data
public class EventType {
    //点击菜单按钮事件
    public static final String CLICK = "CLICK";
    //关注和取消事件
    public static final String SUBSCRIBE = "subscribe";
    //扫描带参数二维码事件
    public static final String TICKET = "TICKET";
    //点击菜单跳转链接事件
    public static final String VIEW = "VIEW";
    //上报地理位置事件
    public static final String LOCATION = "LOCATION";
}
