package Future;


import java.util.concurrent.*;

/**
* 小刘讲源码的示例
* */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future result = executor.submit(task);

        System.out.println("主线程在执行任务");
        System.out.println("task运行结果" + result.get());

        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}

