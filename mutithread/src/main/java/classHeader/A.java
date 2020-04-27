package classHeader;
/*
* 用来验证偏向锁与轻量级锁的性能差异
*
* */
public class A {
    int i = 0;
    public synchronized void parse(){
        i++;
    }
}
