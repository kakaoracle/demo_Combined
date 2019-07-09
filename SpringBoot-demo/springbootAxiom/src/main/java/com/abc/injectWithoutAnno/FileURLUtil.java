package com.abc.injectWithoutAnno;

import java.net.URL;

/**
 * @description: 获取文件路径
 * @author: DeZhao Chen
 * @create: 2019-07-03 11:25
 * description: 关于getClassLoader可以见test
 **/
public class FileURLUtil {
    public static URL getFileURL(String fileName){
        URL resource1 = FileURLUtil.class.getResource("application-context-anno-inject.xml");
        URL resource4 = FileURLUtil.class.getClassLoader().getResource("application-context-anno-inject.xml");
        URL resource2 = FileURLUtil.class.getResource("");
        URL resource3 = FileURLUtil.class.getResource("/");
        return FileURLUtil.class.getClassLoader().getResource(fileName);
    }
}
