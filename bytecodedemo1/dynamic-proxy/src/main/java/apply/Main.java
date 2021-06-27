package apply;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        // 测试代码
        EchoServiceHandler echoServiceHandler = new EchoServiceHandler(new EchoServiceImpl());
        EchoService echoService = (EchoService) Proxy.newProxyInstance(EchoService.class.getClassLoader(), new Class[]{EchoService.class}, echoServiceHandler);
        echoService.echo("test");
    }
}
