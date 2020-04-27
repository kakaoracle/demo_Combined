package classHeader;

import org.openjdk.jol.info.ClassLayout;

/*
* 研究对象头的前7个字节(主要是hashcode,也包括未使用的空间)
*
* */
public class MarkWordTest {
    public static void main(String[] args) {
        L l = new L();
        System.out.println("before hash");
        // 没有计算hashcode之前的对象头
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
        // JVM计算的hashcode
        System.out.println("jvm(转成16进制)----"+Integer.toHexString(l.hashCode()));

        // 计算完后的对象头
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }
}
