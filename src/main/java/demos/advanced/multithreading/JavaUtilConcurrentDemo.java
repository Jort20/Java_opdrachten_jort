package demos.advanced.multithreading;

import java.util.concurrent.*;

public class JavaUtilConcurrentDemo {

    void singleExecutor() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("I am an Executor"));
    }

    void executorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Executor at work");

        System.out.println("doing other stuff");

        try {

            String result = future.get();
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    void future() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Executor at work");

        while(!future.isDone()) {
            System.out.println("Job is running...");
            Thread.sleep(300);
        }
        String result = future.get();
    }

}
