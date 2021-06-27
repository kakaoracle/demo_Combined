package apply;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 注意此处继承的类是jdk的接口,不是自己在另一目录写的同名接口
public class EchoServiceHandler implements InvocationHandler {
    private Object object;

    public EchoServiceHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        return method.invoke(object,args);
    }
}

