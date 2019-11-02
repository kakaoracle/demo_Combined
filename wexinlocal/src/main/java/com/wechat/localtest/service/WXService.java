package com.wechat.localtest.service;

import com.alibaba.fastjson.JSONObject;
import com.wechat.localtest.constant.EventType;
import com.wechat.localtest.constant.MsgType;
import com.wechat.localtest.constant.XmlItem;
import com.wechat.localtest.entity.ArticleEntity;
import com.wechat.localtest.msg.BaseMsg;
import com.wechat.localtest.msg.NewsMsg;
import com.wechat.localtest.msg.TextMsg;
import com.wechat.localtest.util.HttpUtils;
import com.wechat.localtest.util.MsgUtil;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-10-18 13:52
 **/
@Service
@Log
public class WXService {
    private static final String TOKEN = "dog";//token值和开发者账号中配置的相同

    String appID =  "wx0c212040877ca888";
    String appsecret =  "141bd26789de3a5e2760cef7422b57fc";

    /**
     * 验证签名
     * @param timestamp
     * @param nonce
     * @param signature
     */
    public boolean check(String timestamp, String nonce, String signature) {
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = new String[] {TOKEN,timestamp,nonce};
        Arrays.sort(strs);
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0]+strs[1]+strs[2];
        String mysig = sha1(str);
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return mysig.equalsIgnoreCase(signature);
    }


    /**
     * 进行sha1加密
     */
    private static String sha1(String src) {
        try {
            //获取一个加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = md.digest(src.getBytes());
            char[] chars= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for(byte b:digest) {
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[b&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    //要返回的后台业务内容
    private  BaseMsg dealTextMsg(Map<String, String> requestMap) {
        if (requestMap.get(XmlItem.CONTENT).equals("图文")){
            List<ArticleEntity> articles = new ArrayList<>();
            articles.add(new ArticleEntity("标题","描述",
                    "http://image.baidu.com/search/detail?z=0&word=%E7%AB%A5%E6%A2%A6&hs=0&pn=1&spn=0&di=0&pi=44082982964&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cs=4073846589%2C3085928938&os=&simid=&adpicid=0&lpn=0&fm=&sme=&cg=&bdtype=-1&oriquery=&objurl=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F4610b912c8fcc3cef70d70409845d688d53f20f7.jpg&fromurl=&gsm=1a00000000001a&catename=pcindexhot&islist=&querylist=",
                    "http://www.baidu.com"));
            NewsMsg newsMsg = new NewsMsg(requestMap, articles);
            return newsMsg;
        }else {
            TextMsg textMsg = new TextMsg(requestMap, "hello world");
            return textMsg;
        }

    }


    public  String createXmlStr(Map<String,String> requestMap){
        BaseMsg baseMsg = null;
        String msgType = requestMap.get(XmlItem.MSGTYPE);
        switch (msgType){
            case MsgType.TEXT:
                baseMsg = this.dealTextMsg(requestMap);
                break;
            case MsgType.IMAGE:
                break;
            case MsgType.EVENT:
                baseMsg = this.dealEventMsg(requestMap);

            default:
                break;
        }
        if (baseMsg != null){
            //将对象转换为xml字符串
            return MsgUtil.bean2Xml(baseMsg);
        }else {
            return "success";
        }

    }

    //处理各种事件
    private BaseMsg dealEventMsg(Map<String, String> requestMap) {
        BaseMsg baseMsg = new BaseMsg(requestMap);
        //具体的哪一种事件
        String eventType = requestMap.get(XmlItem.EVENTCONTENT);
        switch (eventType){
            case EventType.CLICK:
                baseMsg = dealClickEvent(requestMap);
                break;
            case EventType.LOCATION:
                break;
            case EventType.SUBSCRIBE:
                break;
            case EventType.TICKET:
                break;
            case EventType.VIEW:
                break;
            default:
                break;
        }
        return baseMsg;
    }

    //处理点击事件
    private BaseMsg dealClickEvent(Map<String, String> requestMap) {
        String key = requestMap.get("EventKey");
        switch (key) {
            //点击一菜单点
            case "1":
                //处理点击了第一个一级菜单
                return new TextMsg(requestMap, "你点了一点第一个一级菜单");
            case "32":
                //处理点击了第三个一级菜单的第二个子菜单
                break;
            default:
                break;
        }
        return null;
    }


    //获取token
    public String getToken(){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;
        JSONObject jsonObject = HttpUtils.doGet(url);
        log.info("-----"+jsonObject);
        return jsonObject.getString("access_token");
    }



    public static void dealEvent(Map<String,String> requestMap){
        String event = requestMap.get("Event");
        switch (event){
            case "CLICK":
                break;
            default:
                break;
        }
    };


}























