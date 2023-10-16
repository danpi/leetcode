package hot100.Sub15_动规;

/**
 * hot100.Sub15_dp
 * N1_climbStairs
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N1_climbStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
