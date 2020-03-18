package com.tuling.netty.http_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
第四篇

* 因为多线程会线程数量过多,所以这是单线程,伪代码不可执行
* 这也是netty的原理伪代码(见NettyServer文件)
netty简单来说就是要实现两处不阻塞的方法
* */
public class NioSocketServer伪代码 {
    public static void main(String[] args) throws IOException {
        //用于存储连接socket(不是监听socket)
        List list = new ArrayList<>();
        byte[] bs = new byte[1024];
        //serverSocket专门用来监听
        ServerSocket serverSocket = new ServerSocket();
        // 设置serverSocket整个对象不阻塞,使下方accept方法不阻塞,代码可以往下执行,解决第一处阻塞
        serverSocket.setNoBlocking(false);
        serverSocket.bind(new InetSocketAddress(9876));

        while (true){
            Socket acceptSocket = serverSocket.accept();
            // 没人连接
            if (acceptSocket == null){
                for (Socket item:list){
                    item.getInputStream().read(bs);
                }
            }else { // 有人连接
                // 设置acceptSocket对象为不阻塞,使下方read方法可以不阻塞,代码可以往下执行,解决第二处阻塞
                acceptSocket.setNoBlocking(false);
                list.add(acceptSocket);
                for (Socket item:list){
                    item.getInputStream().read(bs);
                }
            }
        }

    }
}
