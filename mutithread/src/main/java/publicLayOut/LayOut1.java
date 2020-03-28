package publicLayOut;


import org.openjdk.jol.info.ClassLayout;

public class LayOut1 {

    static L l = new L();

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
        System.out.println("start");
        synchronized (l){
            System.out.println("locking");
        }
        System.out.println("end");
    }
}
