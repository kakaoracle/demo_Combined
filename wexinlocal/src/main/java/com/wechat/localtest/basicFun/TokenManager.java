package com.wechat.localtest.basicFun;

import com.alibaba.fastjson.JSONObject;
import com.wechat.localtest.util.HttpUtils;
import lombok.extern.java.Log;

/**
 * @description: token获取与管理(token会在启动时获取,同时也可以手动临时获取以创建菜单等)
 * @author: DeZhao Chen
 * @create: 2019-11-02 18:07
 **/
@Log
public class TokenManager {

    public static void main(String[] args) {
        String appID =  "wx0c212040877ca888";
        String appsecret =  "141bd26789de3a5e2760cef7422b57fc";
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;
        JSONObject jsonObject = HttpUtils.doGet(url);
        log.info("-----"+jsonObject);
    }
}
