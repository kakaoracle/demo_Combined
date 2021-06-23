package kaka;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try{
            //1 知道服务器地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            //2 端口号
            int port = 9999;
            //3 创建一个socket连接
            socket = new Socket(serverIP, port);
            //4 发送消息
            os = socket.getOutputStream();
            os.write("hello".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            if (os != null){
                try {
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if (socket != null){
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }

    }

}
