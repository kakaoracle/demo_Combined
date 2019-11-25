package com.wechat.localtest.basicFun;

import com.alibaba.fastjson.JSONObject;
import com.wechat.localtest.util.HttpUtils;
import lombok.extern.java.Log;

/**
 * @description: 获取用户的相关信息
 * @author: DeZhao Chen
 * @create: 2019-11-02 23:12
 **/
@Log
public class UserInfo {
    public static void main(String[] args) {
        String token = "27_Ju5b6lSzbgAcV24s3kTNw9V2bSGxtNIIcljJmCQKoF2J6YaGhuJB5_pbBfF1NVlyk0uknDeDdhI-JachriCOMHCag1Rjkl2YJCj6J_sqjXzxczcTYIB_kYkGtXFIf0dBIrWqJO3-Y-aVGy6zNOTdAJARSX";//需要先获取token
        String openid="oJEVuxCDD0T-ZiwCfvd7lTyMh_qU";//需要到微信后台确定某一用户的openid
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+token+"&openid="+openid+"&lang=zh_CN";
        JSONObject jsonObject = HttpUtils.doGet(url);
        log.info("-----用户详细信息:"+jsonObject.toString());
    }
}
