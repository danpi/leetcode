package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的几种方式. 继承Thread；实现Runnable；Callable和FutureTask；线程池
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            System.out.println("Enter Callable.");
            Thread.sleep(2000);
            return "Resp from Callable.";
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("Ans: " + futureTask.get());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(callable);
        System.out.println(future.get());
        executor.shutdown();
    }
}
