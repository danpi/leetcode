package framework.dp.subject;

public class N17_CoinChange {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //只使用前i个硬币，背包容量为j时，有几种方法可以填满。
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
//https://leetcode.cn/problems/coin-change-ii/