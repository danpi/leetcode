package hot100.Sub15_动规;

import java.util.Arrays;

/**
 * hot100.Sub15_dp
 * N7_lengthOfLIS
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N7_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
