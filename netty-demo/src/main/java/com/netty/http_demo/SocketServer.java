package com.netty.http_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/*
* 第一篇
* */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        byte[] bs = new byte[1024];
        //serverSocket专门用来监听
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9876));
        //acceptSocket是监听到连接后生成的专门用于通信
        //多个连接进来需要生成多个acceptSocket,因此是个死循环
        while (true){
            System.out.println("等待连接");
            // 第一处阻塞地,没有连接就一直阻塞
            Socket acceptSocket = serverSocket.accept();//一直阻塞,直到有连接该句才会执行
            System.out.println("连接成功,开始接收数据");
            // 第二处阻塞地,有连接但是没有通信就一直阻塞
            acceptSocket.getInputStream().read(bs);
            System.out.println("接收数据完成,即将打印");
            String content = new String(bs);
            System.out.println(content);
        }

    }
}





































