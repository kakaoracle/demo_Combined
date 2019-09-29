package List和Set测试;

import org.junit.Test;

import java.util.*;

/**
 * @description: List和Set的特性测试
 * @author: DeZhao Chen
 * @create: 2019-09-23 18:26
 **/
public class ListSetTest {
    @Test
    public void test1(){
        HashMap<String, String> map = new HashMap<>();
        map.equals("");

        List<String> list=new ArrayList<String>();
        list.add("a1");
        list.add("a3");
        list.add("a2");
        list.add("a5");
        list.add("a4");
        list.equals("a");
        //输出结果：ist=[a1, a3, a2, a5, a4]      按顺序输出
        System.out.println("list="+list);



        Set<String> hashSet=new HashSet<String>();    //jdk7和jdk8有变化
        hashSet.add("a");
        hashSet.add("c");
        hashSet.add("d");
        hashSet.add("b");
        //输出结果：ist=[a, b, c, d]
        System.out.println("list="+hashSet);
        hashSet.equals("a");


        Set<String>  treeSet=new TreeSet<String>();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("d");
        treeSet.add("c");
        //输出结果：treeSet=[a, b, c, d]
        System.out.println("treeSet="+treeSet);


        Set<String>  linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.add("c");
        linkedHashSet.add("a");
        linkedHashSet.add("d");
        linkedHashSet.add("b");
        //输出结果：linkedHashSet=[c, a, d, b]              生成与原来顺序相同的set副本
        System.out.println("linkedHashSet="+linkedHashSet);
    }

}
