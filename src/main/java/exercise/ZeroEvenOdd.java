package exercise;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

//"010203040506..."
public class ZeroEvenOdd {
    private int n;
    private Semaphore semaphoreZero = new Semaphore(1);
    private Semaphore semaphoreOdd = new Semaphore(0);
    private Semaphore semaphoreEven = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaphoreEven.release();
            } else {
                semaphoreOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                semaphoreEven.acquire();
                printNumber.accept(i);
                semaphoreZero.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                semaphoreOdd.acquire();
                printNumber.accept(i);
                semaphoreZero.release();
            }
        }
    }

    static class ThreadDemo extends Thread {
        ZeroEvenOdd zeroEvenOdd;
        int flag;

        ThreadDemo(ZeroEvenOdd zeroEvenOdd, int flag) {
            this.zeroEvenOdd = zeroEvenOdd;
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag == 0) {
                try {
                    zeroEvenOdd.zero(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (flag == 1) {
                try {
                    zeroEvenOdd.odd(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (flag == 2) {
                try {
                    zeroEvenOdd.even(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        new ThreadDemo(zeroEvenOdd, 0).start();
        new ThreadDemo(zeroEvenOdd, 1).start();
        new ThreadDemo(zeroEvenOdd, 2).start();
    }
}
