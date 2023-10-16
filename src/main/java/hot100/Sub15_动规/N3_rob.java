package hot100.Sub15_动规;

/**
 * hot100.Sub15_dp
 * N3_rob
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N3_rob {
    //dp[i]：偷到第i间房能偷到的最大值
    public int rob(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
