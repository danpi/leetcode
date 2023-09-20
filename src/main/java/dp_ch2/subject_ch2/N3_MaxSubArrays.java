package dp_ch2.subject_ch2;

public class N3_MaxSubArrays {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
//https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/