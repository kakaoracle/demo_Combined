package com.abc.类的加载和实例化.util;

import com.abc.类的加载和实例化.FileURLUtil;
import com.abc.类的加载和实例化.model.BeanDefinition;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import jdk.nashorn.internal.runtime.regexp.joni.constants.EncloseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 读取json工具类
 * @author: DeZhao Chen
 * @create: 2019-07-03 17:02
 **/
public class JsonReaderUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JsonReaderUtil.class);

    public static List<BeanDefinition> readJson(String fileName){
        Gson gson = new Gson();
        HashMap<String ,String> elements = Maps.newHashMap();
        URL fileURL = FileURLUtil.getFileURL(fileName);
        try {
            gson.fromJson(new FileReader(fileURL.getPath()),HashMap.class);
        } catch (FileNotFoundException e) {
            LOG.error("fileNotFoundException",e);
        }

        ArrayList<BeanDefinition> beanDefinitions = Lists.newArrayList();
        for (Map.Entry<String,String> entry:elements.entrySet()){
            beanDefinitions.add(new BeanDefinition(entry.getKey(), entry.getValue()));
        }

        return beanDefinitions;
    }



}
