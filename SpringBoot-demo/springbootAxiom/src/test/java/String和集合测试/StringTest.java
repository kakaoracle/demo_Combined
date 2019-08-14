package String和集合测试;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 测试String, StringBuffer, StringBuilder
 * @author: DeZhao Chen
 * @create: 2019-08-13 18:04
 **/
public class StringTest {

    @Test
    public void testStr(){
        String s = new String();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("111");
        StringBuilder stringBuilder = new StringBuilder();
    }

    @Test
    public void testMapAndList(){
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("a","b");
        List<Object> list = new ArrayList<>();
        LinkedList<Object> linkedList = new LinkedList<>();



    }


}
