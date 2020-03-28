package multiThread;
/*
* volatile的有序性-能够保证
*   并发场景会出现指令重排比如x=b会在a=1的前面
* */
public class VolatileReOrderSample {
    private  static int x=0,y=0;
    private static int a=0,b=0;
    // private volatile static int a=0,b=0;
    static  Object object = new Object();

    public static void main(String[] args) throws Exception {
        int i=0;
        for(;;){
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a=1;
                    x=b;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b=1;
                    y=a;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            /*
            * 如果x=b排序到a=1前面同时y=a排序到b=1前面,则x与y都为0,证明发生了指令重排
            * */
            String result = "第"+i+"次("+x+","+y+")";
            if (x == 0 && y==0){
                System.err.println(result);
                break;
            }else {
                System.out.println(result);
            }

        }
    }
}
