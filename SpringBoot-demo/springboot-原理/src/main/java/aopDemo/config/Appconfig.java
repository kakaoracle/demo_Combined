package aopDemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: Dezhao Chen
 * @create: 2019-04-07 08:52
 **/
@Configuration
@ComponentScan("aopDemo")
@EnableAspectJAutoProxy
public class Appconfig {
    
}
