package dp_ch2;

import java.util.ArrayList;
import java.util.List;

public class fibonacci {
    //纯递归
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //递归+备忘录
    public int fib1(int n) {
        List<Integer> memo = new ArrayList<>(n + 1);
        return helper(memo, n);
    }

    private int helper(List<Integer> memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo.get(n) != 0) {
            return memo.get(n);
        }
        memo.set(n, helper(memo, n - 1) + helper(memo, n - 2));
        return memo.get(n);
    }

    //dp table
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[1] = memo[2] = 1;
        for (int i = 3; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
