package com.wechat.localtest.customMenu;

import com.alibaba.fastjson.JSONObject;
import com.wechat.localtest.util.HttpUtils;
import lombok.extern.java.Log;

/**
 * @description: 查询自定义菜单的具体内容(返回的内容是json)
 * @author: DeZhao Chen
 * @create: 2019-11-02 12:54
 **/
@Log
public class GetMenu {
    public static void main(String[] args) {
        String token = "27_FhW7Jm6vEB0B6OOkNFMDqcCN9IQCHcsheCgG2zbqipPDkgk_vWLtn9d-n85rHAc_4PvBgmnHBc1GkLQ9lwAYY5men1xYZb-xXZvByJYvtm_toln8J_XbUSLHTqBszWB68MnPRd16fTfdo5ZtAHCdACAELG";
        String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token="+token;
        JSONObject jsonObject = HttpUtils.doGet(url);
        log.info(jsonObject.toString());
    }
}
