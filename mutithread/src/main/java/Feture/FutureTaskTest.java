package Feture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureTaskTest {


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<List> futureTask = new FutureTask<>(new Callable<List>() {
            @Override
            public List call() throws Exception {
                return Arrays.asList("1","2");
            }
        });
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }

}
