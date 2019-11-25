package annotation;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-11-07 10:28
 **/
@Component
public class SgtPeppers implements CompactDisc{

    private String kind="CDPlayer";
    @Override
    public void play() {
        System.out.println(kind);
    }
}
