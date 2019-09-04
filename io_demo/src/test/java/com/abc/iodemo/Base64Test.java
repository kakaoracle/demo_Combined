package com.abc.iodemo;

import com.abc.iodemo.util.Base64Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 测试base64对于文件与字符串的转换
 * @author: DeZhao Chen
 * @create: 2019-08-28 19:27
 **/
public class Base64Test {

    @Test
    public void testFileToStr(){
        //图片地址
        String imgPath = "C:\\Users\\kakao\\Desktop\\1.jpg";
        String resultStr = Base64Util.GetImageStr(imgPath);
        System.out.println(resultStr);
    }


    @Test
    public void testStrToFile(){
        //图片对应的base64串
        String imgStr = Base64Util.GetImageStr("C:\\Users\\kakao\\Desktop\\1.jpg");

        //生成的图片地址与名字
        String dirPath = "C:\\Users\\kakao\\Desktop\\2.png";
        Base64Util.GenerateImage(imgStr,dirPath);

    }


    @Test
    public void testList(){
        List list = null;
        List list1 = new ArrayList();
        System.out.println(list==null);
        System.out.println(list1==null);
        System.out.println(list1.isEmpty());
        System.out.println(list.isEmpty());



    }

}
