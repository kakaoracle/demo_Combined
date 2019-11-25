import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-11-07 09:24
 **/
public class Main {
    public static void main(String[] args) {
        //创建一个spring的IOC容器对象
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        //从ioc容器中获得bean的实例
        HelloWorld helloWorld=(HelloWorld)context.getBean("helloworld");
        helloWorld.getName();
        helloWorld.getTracks();
    }
}
