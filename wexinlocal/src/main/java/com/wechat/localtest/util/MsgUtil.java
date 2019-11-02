package com.wechat.localtest.util;

import com.thoughtworks.xstream.XStream;
import com.wechat.localtest.entity.ArticleEntity;
import com.wechat.localtest.msg.*;
import com.wechat.localtest.service.WXService;
import lombok.extern.java.Log;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-10-18 17:57
 **/
@Log
public class MsgUtil {



    @Autowired
    WXService WXService;

    public static Map<String, String> xml2Map(HttpServletRequest request)
            throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        return map;
    }

//xml中标签是类名或者属性名,但是生成时类名一级需要变成xml之类标签,因此需要用别名
    public static String bean2Xml(BaseMsg baseMsg) {
        XStream xStream = new XStream();
        xStream.processAnnotations(TextMsg.class);
        xStream.processAnnotations(ImageMsg.class);
        xStream.processAnnotations(VideoMsg.class);
        xStream.processAnnotations(MusicMsg.class);
        xStream.processAnnotations(VoiceMsg.class);
        xStream.processAnnotations(NewsMsg.class);
        xStream.processAnnotations(ArticleEntity.class);
        return  xStream.toXML(baseMsg);
    }



}
