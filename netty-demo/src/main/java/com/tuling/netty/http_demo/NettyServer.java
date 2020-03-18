package com.tuling.netty.http_demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
/*
第五篇
* 鲁班学院
* */
public class NettyServer {
    public static void main(String[] args) {
        List<SocketChannel> list = new ArrayList<>();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(9091));
        //设置为非阻塞
        ssc.configureBlocking(false);
        while (true){
            Selector selector = Selector.open();
            SocketChannel socketChannel = ssc.accept();
            if (socketChannel == null){
                Thread.sleep(1000);
                System.out.println("无连接");
                for (SocketChannel channel:list){
                    int k = channel.read(byteBuffer);
                    System.out.println(k);
                    if (k!=0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array()));
                    }
                }
            }else {
                socketChannel.configureBlocking(false);
                list.add(socketChannel);
                // 得到套接字,循环所有套接字,通过套接字获取数据
                for (SocketChannel channel:list){
                    int k = channel.read(byteBuffer);
                    System.out.println(k+"====");
                    if (k!=0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array()));
                    }
                }
            }
        }
    }
}
