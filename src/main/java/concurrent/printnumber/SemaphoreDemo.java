package concurrent.printnumber;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo extends Thread {
    private String content;
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);
    private Semaphore acquire;
    private Semaphore release;

    private SemaphoreDemo(String content, Semaphore acquire, Semaphore release) {
        this.content = content;
        this.acquire = acquire;
        this.release = release;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                this.acquire.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(this.content);
            this.release.release();
        }
    }

    public static void main(String[] args) {
        new SemaphoreDemo("小", SemaphoreDemo.semaphoreA, SemaphoreDemo.semaphoreB).start();
        new SemaphoreDemo("红", SemaphoreDemo.semaphoreB, SemaphoreDemo.semaphoreC).start();
        new SemaphoreDemo("书\n", SemaphoreDemo.semaphoreC, SemaphoreDemo.semaphoreA).start();
    }
}

