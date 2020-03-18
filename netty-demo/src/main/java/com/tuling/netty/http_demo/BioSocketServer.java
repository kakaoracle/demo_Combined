package com.tuling.netty.http_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/*
* 第三篇
*
* */
public class BioSocketServer {
    public static void main(String[] args) throws IOException {
        byte[] bs = new byte[1024];
        //serverSocket专门用来监听
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9876));
        //acceptSocket是监听到连接后生成的专门用于通信
        //多个连接进来需要生成多个acceptSocket,因此是个死循环
        while (true){
            System.out.println("等待连接");
            Socket acceptSocket = serverSocket.accept();//一直阻塞,直到有连接该句才会执行
            System.out.println("连接成功");
            Thread thread = new Thread(new ExecuteSocket(acceptSocket));
            thread.start();
        }

    }

    static class ExecuteSocket implements Runnable{
        byte[] bs = new byte[1024];
        Socket socket;
        // 处理每个客户端连接--读写
        public ExecuteSocket(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.getInputStream().read(bs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
