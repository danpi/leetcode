package framework.dp.subject;

import java.util.Arrays;

public class N1_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int LIS = 0;
        for (int i = 0; i < dp.length; i++) {
            LIS = Math.max(LIS, dp[i]);
        }
        return LIS;
    }
}
//https://leetcode.cn/problems/longest-increasing-subsequence/