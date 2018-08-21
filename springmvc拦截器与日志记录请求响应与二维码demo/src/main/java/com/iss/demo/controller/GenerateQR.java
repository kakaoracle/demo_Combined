package com.iss.demo.controller;

import com.google.zxing.WriterException;
import com.iss.demo.Utils.QRCodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PrivateKey;

@RestController
public class GenerateQR {
    @RequestMapping("/generateqr")
    public void generateqr(String content,HttpServletResponse response){
      int width = 300;
      int height = 300;
      ServletOutputStream outputStream = null;
      System.out.println(">>>>content");
        try {
            //向响应对象response中写入流
            outputStream = response.getOutputStream();
            QRCodeUtil.writeToStream(content, outputStream, width, height);
            //调用二维码图片所对应的字符串
            QRCodeUtil.toBufferedImage(content, width, height);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
