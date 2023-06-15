package framework_ch1.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        //dp数组大小为amount+1, 初始值也为amount+1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //base case
        dp[0] = 0;
        //外层循环遍历所有状态
        for (int i = 0; i < dp.length; i++) {
            //内循环求某个状态下，所有选择的最小值
            for (int coin : coins) {
                //子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    private Map<Integer, Integer> memo;

    public int coinChange2(int[] coins, int amount) {
        memo = new HashMap<>();
        return dp(coins, amount);
    }

    private int dp(int[] coins, int n) {
        //查备忘录，避免重复
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem = dp(coins, n - coin);
            if (subproblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subproblem);
        }
        //记入备忘录
        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        memo.put(n, res);
        return res;
    }
}
//https://leetcode.cn/problems/coin-change/
