package com.iss;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFromUrl {
    public static void main(String[] args) throws Exception {
        //第一种方法,不需要base64进行转码,测试通过
        //downloadPic();
        //第二种方法,用base64转码,接收到一串字符串之后进行转换成图片文件,测试通过
        //downloadPicWithBase64();
        //
        downloadVideoWithBase64();
    }

    private static void downloadVideoWithBase64() throws Exception {
        String urlString = "http://localhost:8080/韦德-醉拳.wmv";//韦德-醉拳.wmv是一段视频,放置在resources/static目录下
        String filename = "韦德-醉拳.wmv";
        String savePath = "C:\\Users\\Arthur\\Desktop\\des";
        String base64Str = GetBase64Str(urlString);
        System.out.println("生成的base64字符串是:"+base64Str);
        boolean result = GenerateFile(base64Str, savePath, filename);
    }

    private static void downloadPicWithBase64() throws Exception {
        String urlString = "http://localhost:8080/01.jpg";//01.jpg是一张图片,放置在resources/static目录下
        String filename = "astronomy.jpg";
        String savePath = "C:\\Users\\Arthur\\Desktop\\des";
        String base64Str = GetBase64Str(urlString);
        System.out.println("生成的base64字符串是:"+base64Str);
        boolean result = GenerateFile(base64Str, savePath, filename);
    }

    public static void downloadPic() throws Exception {
        String urlString = "http://localhost:8080/01.jpg";//01.jpg是一张图片,放置在resources/static目录下
        String filename = "astronomy.jpg";
        String savePath = "C:\\Users\\Arthur\\Desktop\\des";
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

    // 文件转化成base64字符串
    public static String GetBase64Str(String urlString) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();
        byte[] data = null;
        // 读取图片字节数组
        try {
            data = new byte[is.available()];
            is.read(data);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    // base64字符串转化成文件
    public static boolean GenerateFile(String base64Str,String savePath,String fileName) {
        if (base64Str == null) // 图像数据为空
        {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(base64Str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(savePath+"\\"+fileName);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
