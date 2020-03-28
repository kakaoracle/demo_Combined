package multiThread;
/*
* volatile的原子性--无法保证
* */
public class VolatileAtomicSample {
    private static  volatile  int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            Thread thread = new Thread(()->{
                for (int j =0;j<1000;j++){
                    counter++;
                }
            });
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println(counter);
    }

}
