package printxyzinturn;

/**
 * 两个线程交替打印xy
 */
public class PrintXY {
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread(); //代码三处
        new Thread(printThread, "Thread-A").start();
        new Thread(printThread, "Thread-B").start();
    }
}

class PrintThread implements Runnable {
    private  int count = 0;
    @Override
    public void run() {
        synchronized (this) {
            while (count <= 100) {
                //唤醒其他需要this锁的进程来竞争锁，当前进程等到临界区代码执行完毕才释放锁
                this.notify();
                System.out.println(Thread.currentThread().getName() + "当前数字是：" + count++);
                //立即阻塞当前线程
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

