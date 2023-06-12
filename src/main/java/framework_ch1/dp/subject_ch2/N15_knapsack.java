package framework_ch1.dp.subject_ch2;

//0-1背包问题
public class N15_knapsack {
    public double maxPrice(int w, int n, int[] wt, int[] val) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1] + val[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }
}
