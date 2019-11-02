package com.wechat.localtest.customMenu;

import com.alibaba.fastjson.JSONObject;
import com.wechat.localtest.entity.*;
import com.wechat.localtest.service.WXService;
import com.wechat.localtest.util.HttpUtils;
import lombok.extern.java.Log;

/**
 * @description: 创建菜单
 * @author: DeZhao Chen
 * @create: 2019-10-28 22:18
 **/
@Log
public class CreateMenu {



    public static void main(String[] args) {

        WXService WXService = new WXService();

        //菜单对象
        Button btn = new Button();
        //第一个一级菜单
        btn.getButton().add(new ClickButton("一级点击", "1"));
        //第二个一级菜单
        btn.getButton().add(new ViewButton("一级跳转", "http://www.baidu.com"));
        //创建第三个一级菜单
        SubButton sb = new SubButton("有子菜单");
        //为第三个一级菜单增加子菜单
        sb.getSub_button().add(new PhotoOrAlbumButton("传图", "31"));
        sb.getSub_button().add(new ClickButton("点击", "32"));
        sb.getSub_button().add(new ViewButton("网易新闻", "http://news.163.com"));
        //加入第三个一级菜单
        btn.getButton().add(sb);
        //转为json
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(btn);
        //准备url
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+ WXService.getToken();
        //发送请求
        JSONObject postResult = HttpUtils.doPostJson(url, jsonObject.toString());
        if (postResult.getString("errmsg").equals("ok")){
            log.info("创建菜单成功");
        }

    }
}
