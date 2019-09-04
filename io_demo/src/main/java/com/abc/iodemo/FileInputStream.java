package com.abc.iodemo;

import java.io.File;
import java.io.InputStream;

/*
所谓的流,其实就是一个类,叫法奇怪而已
FileInputStream的构造函数有两个,FileInputStream(File)与FIleInputStream(String)
 *文件地址两种写法,
 *绝对地址:机器上c或d盘的物理地址
 *相对地址:类似"./abc.txt"形式,如果程序与文件地址没有相对目录关系则无法识别
*/
public class FileInputStream {
    public static void main(String[] args) throws  Exception{
        //也可以用File file = new File("C:\\Users\\cwx597167\\Desktop\\NIO_demo\\src\\main\\sources\\NIO_IO_Read_Test.txt");
        /*InputStream inputStream = new FileInputStream(new File("C:\\Users\\kakao\\Desktop\\1.jpg"));
        while (inputStream.read() != -1){
            System.out.println((char) inputStream.read());//由于read方法的返回值为int,需要转换为char进行输出
        }
        inputStream.close();*/
    }
}
