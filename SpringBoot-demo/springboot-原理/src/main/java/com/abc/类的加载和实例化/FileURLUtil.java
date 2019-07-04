package com.abc.类的加载和实例化;

import java.net.URL;

/**
 * @description: 获取文件路径
 * @author: DeZhao Chen
 * @create: 2019-07-03 11:25
 * description: 关于getClassLoader可以见test
 **/
public class FileURLUtil {
    public static URL getFileURL(String fileName){
        return FileURLUtil.class.getClassLoader().getResource(fileName);
    }
}
