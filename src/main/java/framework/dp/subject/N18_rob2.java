package framework.dp.subject;

import java.util.Arrays;

public class N18_rob2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[1], nums[0]);
        }
        return Math.max(robx(nums, 0, n - 2), robx(nums, 1, n - 1));
    }

    public int robx(int[] allNums, int start, int end) {
        int[] nums = new int[end - start + 1];
        for (int i = 0; i < end - start + 1; i++) {
            nums[i] = allNums[i + start];
        }
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
//https://leetcode.cn/problems/house-robber-ii/