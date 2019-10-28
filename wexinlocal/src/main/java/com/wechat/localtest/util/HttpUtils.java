package com.wechat.localtest.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.wechat.localtest.constant.CommonConstant;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: Http请求工具
 * @author: kakaoracle
 * @create: 2019-02-23 23:00
 **/
public class HttpUtils {

    public static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 发送get请求
     * @param url
     * @param param
     * @return
     */
    public static JSONObject doGet(String url, Map<String, String> param) {
        log.info("***HttpUtils-url:"+url+",param:"+param);
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        JSONObject returnObject = null;

        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            //設置httpGet的头部參數信息,防止误认为爬虫
            httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
            httpGet.setHeader("Accept-Encoding", "gzip, deflate");
            httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
            httpGet.addHeader("Cache-Control","no-cache");
            httpGet.addHeader("Pragma","no-cache");
            httpGet.setHeader("Connection", "keep-alive");
            httpGet.addHeader("Upgrade-Insecure-Requests","1");
            httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36name, value");
            // 执行请求
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == CommonConstant.HTTP_CODE_OK){
                 returnObject = (JSONObject) JSON.parse(EntityUtils.toString(response.getEntity(), "utf-8"));
                log.info("***http请求响应:"+returnObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnObject;
    }

    public static JSONObject doGet(String url) {
        return doGet(url, null);
    }

    /**
     * 发送POST_MAP请求
     * @param url
     * @param param
     * @return
     */
    public static JSONObject doPost(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        JSONObject returnObject = null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == CommonConstant.HTTP_CODE_OK){
                returnObject = (JSONObject) JSON.parse(EntityUtils.toString(response.getEntity(), "utf-8"));
                log.info("***http请求响应:"+returnObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnObject;
    }


    public static JSONObject doPost(String url) {
        return doPost(url, null);
    }

    /**
     * 发送POST_JSON请求
     * @param url
     * @param json
     * @return
     */
    public static JSONObject doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        JSONObject returnObject = null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == CommonConstant.HTTP_CODE_OK){
                returnObject = (JSONObject) JSON.parse(EntityUtils.toString(response.getEntity(), "utf-8"));
                log.info("***http请求响应:"+returnObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnObject;
    }
}
