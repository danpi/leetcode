package concurrent.printnumber;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int cur;

    private Semaphore zeroSema = new Semaphore(1);
    private Semaphore oddSema = new Semaphore(0);//奇数
    private Semaphore evenSema = new Semaphore(0);//偶数

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public ThreadRun createThread(int flag) {
        return new ThreadRun(this, flag);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) {
        for (int i = 1; i <= n; i++) {
            try {
                zeroSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printNumber.accept(0);
            if ((i & 1) == 1) {//奇数
                oddSema.release();
            } else {
                evenSema.release();
            }
        }
    }

    public void even(IntConsumer printNumber) {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {//偶数 打印偶数 并释放zero的线程
                try {
                    evenSema.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {//奇数，打印奇数，并释放zero的线程
                try {
                    oddSema.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }

    class ThreadRun extends Thread {
        ZeroEvenOdd zeroEvenOdd;
        int flag;

        public ThreadRun(ZeroEvenOdd zeroEvenOdd, int flag) {
            this.zeroEvenOdd = zeroEvenOdd;
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag == 0) {
                zeroEvenOdd.zero((x) -> {
                    System.out.print(x);
                });
            } else if (flag == 1) {
                zeroEvenOdd.odd((x) -> {
                    System.out.print(x);
                });
            } else if (flag == 2) {
                zeroEvenOdd.even((x) -> {
                    System.out.print(x);
                });
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        zeroEvenOdd.createThread(0).start();
        zeroEvenOdd.createThread(1).start();
        zeroEvenOdd.createThread(2).start();
//        new ThreadRun(zeroEvenOdd, 0).start();
//        new ThreadDemo(zeroEvenOdd, 0).start();
//        new ThreadDemo(zeroEvenOdd, 1).start();
//        new ThreadDemo(zeroEvenOdd, 2).start();
    }
}
