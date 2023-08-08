package concurrent.printnumber;

import java.util.concurrent.Semaphore;

//https://blog.csdn.net/hefenglian/article/details/82596072
/**
 * 建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 */
public class Semaphore_ABC {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    public static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    A.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("A");
                B.release();
            }
        }
    }

    public static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    B.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("B");
                C.release();
            }
        }
    }

    public static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    C.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("C");
                A.release();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
