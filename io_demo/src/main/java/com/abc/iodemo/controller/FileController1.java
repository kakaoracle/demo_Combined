package com.abc.iodemo.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 接收前台ultipartFile类型的文件,放到自身服务器中,用最简单的input和output
 */
@RestController
@Log
public class FileController1 {
    @GetMapping("fileRev")
    public void fileRev(@RequestParam("file") MultipartFile file){
        int len;
        int saveBurnResult;
        boolean saveFileResult = true;
        byte[] bytes = new byte[1024];
        InputStream is = null;
        String dirPath = "C:\\Users\\kakao\\Desktop";
        String fileName = file.getOriginalFilename().split("\\.")[0];
        try {
            is = file.getInputStream();
            /* 写入文件 */
            createDir(dirPath);
            OutputStream os = new FileOutputStream(dirPath+"\\"+file.getOriginalFilename());
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            //log.info("已经写入完毕");
            out.close(); // 关闭流
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            //log.info("******写入文件失败"+e.toString());

        }}

    public boolean createDir(String path){
        File file = null;
        file = new File(path);
        if (!file.exists()){
            return file.mkdir();
        }else {
            return false;
        }
    }
}