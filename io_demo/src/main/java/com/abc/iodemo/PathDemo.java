package com.abc.iodemo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * inputstream()参数可以是url,可以是file,也可以是paths
 * Files接口,是java.nio.file.files类,而常用的File是java.io.File类
 * Paths接口
 */
public class PathDemo {
    public static void main(String[] args) throws IOException {
        String dirPath = "C:\\Users\\kakao\\Desktop\\demo1.txt";
        pathInput(dirPath);
    }

    private static void pathInput(String dirPath) throws IOException {
        //对比之前的: new InputStream(Paths.get(dirPath));
        InputStream is= Files.newInputStream(Paths.get(dirPath));
    }

}
