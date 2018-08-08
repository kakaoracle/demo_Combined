import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
/*
* 之前的请求-响应模型浏览器如果要接收消息,需要先发送请求
	新的业务需求:QQ消息,自己没有发送,但是服务器需要更新别人对自己的信息
				 证券实时波动信息
	用请求-响应模型就需要轮询(polling),且request的header非常长,特别的消耗时间与资源
	WebSocket:
	全双工通信,
	通过ws协议,取代单个TCP套接字,但是WebSocket允许跨域同时WebSocket可以服务器不接收请求情况下直接向浏览器发送信息

问题:
	session是服务器端的会话平台,内容只能在服务端操作,为何前端的send方法能够操作session中内容?
	解答:web层中有request.getsession()方法,也就是说,从请求中能够找到session字符串
	cookie的发送问题:
	每一个http报文的请求头中都有"cookie"字段,添加cookie就是给其赋值,浏览器接收报文,会将cookie写入到本地文件中
	session的发送问题:
	session的内容也是存储在服务器的/tmp目录下
*
* */
@ServerEndpoint("/hello")
public class socketcontroller {
    @OnOpen
    public void onopen(Session session){
        System.out.println(">>>连接成功");
    }
    @OnClose
    public void onclose(Session session){
        System.out.println(">>>关闭连接");
    }
    @OnMessage
    public void onmessage(Session session,String msg) throws IOException {
        String returnmes="client"+session.getId()+"say:"+msg;
        System.out.println(returnmes);
        session.getBasicRemote().sendText(returnmes);
    }
}
