package concurrent.printnumber;

import concurrent.printnumber.ZeroEvenOdd;

public class ThreadDemo extends Thread {
    ZeroEvenOdd zeroEvenOdd;
    int flag;

    public ThreadDemo(ZeroEvenOdd zeroEvenOdd, int flag) {
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
