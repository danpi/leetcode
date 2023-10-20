package concurrent.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TaskOrderExec {
    //单线程池依次提交
    public void singleExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new InnerTask(null));
        executorService.shutdown();
    }

    //schedule线程池，根据调度顺序提交
    public void scheduleExecutor() throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        ScheduledFuture future1 = executorService.schedule(new InnerTask(null), 0, TimeUnit.SECONDS);
        ScheduledFuture future2 =
                executorService.schedule(new InnerTask(future1), 0, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    class InnerTask implements Runnable {
        private final ScheduledFuture<?> previousFuture;

        InnerTask(ScheduledFuture<?> previousFuture) {
            this.previousFuture = previousFuture;
        }

        @Override
        public void run() {
            if (previousFuture != null) {
                try {
                    previousFuture.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TaskOrderExec taskOrderExec = new TaskOrderExec();
        taskOrderExec.singleExecutor();
        taskOrderExec.scheduleExecutor();

    }
}
