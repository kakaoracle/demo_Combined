package com.abc.iodemo;

import java.io.FileReader;

/*FileReader利用的是FileInputStream进行功能实现
* public FileReader(File file) throws FileNotFoundException {
        super(new FileInputStream(file));
    }
FileReader与FileInputStream基本上可以互用,只不过前者输出中文不乱码
* * */
public class FileReaderDemo {
    public static void main(String[]args) throws Exception {
        FileReader fileReader = new FileReader("C:\\Users\\Arthur\\Desktop\\IO_demo\\src\\main\\java\\NIO_IO_Read_Test.txt");
        while (fileReader.read() != -1) {
            System.out.println((char) fileReader.read());
        }
        fileReader.close();
    }
}
