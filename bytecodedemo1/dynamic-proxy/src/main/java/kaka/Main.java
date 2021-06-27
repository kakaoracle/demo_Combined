package kaka;

import java.io.IOException;
import java.lang.reflect.Method;

public class Main {
    // 相亲代理
    public static class FindWomanProxy implements InvocationHandler{
        // 被代理的对象
        private FindWoman woman;
        public FindWomanProxy(FindWoman woman) {
            this.woman = woman ;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //在真实的对象执行之前我们可以添加自己的操作
            System.out.println("相亲代理正在筛选80+的女士");
            // 筛选 完成 交给 程序员去消费相亲
            return method.invoke(woman, args);
        }

    }
    // 相亲 接口
    public static interface FindWoman {
        public void find();
    }
    // java 程序员相亲
    public static class JavaFindWoman implements FindWoman{
        @Override
        public void find() {
            System.err.println("java程序员相亲 ");
        }
    }
    public static void main(String[] args) throws IOException {
        // 构造相亲代理 ， 把java程序员传进去
        FindWomanProxy proxy = new FindWomanProxy(new JavaFindWoman());
        // 将动态生成的class 输出到文件
        System.getProperties().put("com.kaka.saveGeneratedFiles", "true");
        FindWoman findWoman = (FindWoman) Proxy.newProxyInstance(FindWoman.class, proxy);
        findWoman.find();

    }
}
