package annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: DeZhao Chen
        * @create: 2019-11-07 10:32
        **/
@Configuration
@ComponentScan
//没有其他配置的话，则只会扫描当前包和当前包下面的子包
public class CDPlayerConfig {
}