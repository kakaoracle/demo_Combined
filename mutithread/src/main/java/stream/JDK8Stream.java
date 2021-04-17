package stream;

import java.util.Arrays;
import java.util.List;

/**
 * 研究jdk8中的stream涉及的多线程场景
 */
public class JDK8Stream {
    public static void main(String[] args) {
        int i = 0;
        String count = "iii";
        List<String> indexs = Arrays.asList("1", "2", "3", "4");
        // 下面这种场景是无法实现的.因为1,匿名函数变量必须是final的,2:lamda表达式也必须是final变量
        //indexs.stream().forEach(e -> i++);
        System.out.println(i);
    }

}
