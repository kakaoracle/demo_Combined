package countdownlatch;

public class MyLatch {
    private int total;
    private int counter = 0;

    public MyLatch(int total) {
        this.total = total;
    }

    public void countDown() {
        synchronized (this) {
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            while (counter != total) {
                this.wait();
            }
        }

    }
}
