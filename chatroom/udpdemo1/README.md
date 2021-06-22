## 工程目录
- tcpdemo1: tcp实现的一个聊天室
- tcpdemo2: 最简单的tcp连接,从建立连接,到关闭连接,不支持手动输入等任何形式
## UDP
UDP 是User Datagram Protocol的简称,因此用DatagramSocket
UDP只是自己创建了端口,监听这处端口,发送时直接发送另一个ip+端口,至于对方是否在监听无所谓
就是最简单的实现原理,不考虑是否连接上,直接发送消息,接不接收也不管

## TCP和UDP工程使用
TCP是可以建立多个客户端,然后先启动一个服务端,
然后多个客户端之间接收消息是通过服务端的Message进行转发
效果是,客户端1发送的消息,服务端能接收到,同时其他客户端也都能接收到

## 参考链接
https://www.jiweichengzhu.com/article/4d4bd20aaa524b0d961fb0f1b744b3a4
https://blog.csdn.net/BushQiang/article/details/79822349