package concurrent.printnumber;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * concurrent.printnumber
 * ZeroEvenOdd
 *
 * @author hbn
 * @date 2023/9/17
 */

public class ZeroEvenOdd {
    private int n;
    private Semaphore semaphoreZero = new Semaphore(1);
    private Semaphore semaphoreEven = new Semaphore(0);
    private Semaphore semaphoreOdd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (i%2==1) {
                semaphoreOdd.release();
            }else {
                semaphoreEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            if (i%2==0){
                semaphoreEven.acquire();
                printNumber.accept(i);
                semaphoreZero.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            if (i%2==1){
                semaphoreOdd.acquire();
                printNumber.accept(i);
                semaphoreZero.release();
            }
        }
    }

    static class ThreadRun extends Thread{
        private  ZeroEvenOdd zeroEvenOdd;
        private int flag;
        public ThreadRun(ZeroEvenOdd zeroEvenOdd,int flag){
            this.zeroEvenOdd=zeroEvenOdd;
            this.flag=flag;
        }

        @Override
        public void run(){
            if (flag==0){
                try {
                    zeroEvenOdd.zero(i->System.out.print(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if (flag==1){
                try {
                    zeroEvenOdd.odd((v)->{System.out.print(v);});
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if (flag==2){
                try {
                    zeroEvenOdd.even((i)->System.out.print(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd=new ZeroEvenOdd(6);
        new ThreadRun(zeroEvenOdd,0).start();
        new ThreadRun(zeroEvenOdd,1).start();
        new ThreadRun(zeroEvenOdd,2).start();
    }
}
