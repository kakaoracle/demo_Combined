package com.abc.iodemo;

import java.io.FileInputStream;
import java.io.InputStream;

public class BufferedInputStream {
    public static void main(String[] args) throws Exception {
        //BufferedInputStream与FileInputStream的区别就在于下面这一句,当byte[1]时,二者相同,而当数值变大时候,单次读取数量变多,总体读取速度变快
        /*InputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\Arthur\\Desktop\\IO_demo\\src\\main\\java\\NIO_IO_Read_Test.txt"));
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        while (read != -1){
            for (int i=0;i<read;i++){
                System.out.println((char)bytes[i]);
                read = inputStream.read(bytes);
            }
        }
        inputStream.close();*/
    }
}
