package kaka;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Proxy {
    // 生成的 class 缓存
    private static final Map<String, Class<?>> classMapper = new HashMap<>();
    // 类的名称 自增 计数
    final static AtomicLong atomicLong = new AtomicLong();
    // 利用 Javassist 作为底层实现 ， 你也可以用cglib ， asm ，javax.tools.JavaCompiler 等
    final static ClassGenerator classGenerator = new JavassistClassGenerator();

    public static Object newProxyInstance(Class<?> interClazz, InvocationHandler handler) {
        // form 缓存
        Class<?> proxyClass = classMapper.get(interClazz.getName());
        if (proxyClass == null) {
            //
            proxyClass = apply(interClazz, handler);
        }
        try {
            return proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> apply(Class<?> interClazz, InvocationHandler handler) {
        // 接口名 比如 ： com.a.b.A
        String name = interClazz.getName();
        int n = name.lastIndexOf('.');
        // 截取包名 ： com.a.b
        String proxyPkg = ((n == -1) ? "" : name.substring(0, n + 1));
        // 生成的代理类名称
        String className = "$Proxy" + atomicLong.getAndIncrement();
        try {
            // 生成 类
            return classGenerator.createClass(proxyPkg, className, interClazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}