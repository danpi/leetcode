package concurrent.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CreateThread {
    static class CreateCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Enter callable.");
            Thread.sleep(2000);
            return "Callable finish";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThread createThread = new CreateThread();
        FutureTask<String> futureTask = new FutureTask<>(new CreateCallable());
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        System.out.println(futureTask.get());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new CreateCallable());
        System.out.println(future.get());
        executorService.shutdown();
    }
}
