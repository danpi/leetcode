package hot100.Sub15_动规;

/**
 * hot100.Sub15_dp
 * N8_maxProduct
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N8_maxProduct {
    //dp[i]:前i个数字组成的最大乘积
    //dpmax[i]=max(dpmax[i-1]*num[i], num[i], dpmin[i-1]*num[i])
    //dpmin[i]=min(dpmin[i-1]*num[i], num[i], dpmax[i-1]*num[i])
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n + 1];
        int[] minDp = new int[n + 1];
        maxDp[0] = 1;
        minDp[0] = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i - 1], Math.max(nums[i - 1], minDp[i - 1] * nums[i - 1]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i - 1], Math.min(nums[i - 1], maxDp[i - 1] * nums[i - 1]));
            ans = Math.max(maxDp[i], ans);
        }
        return ans;
    }
}
