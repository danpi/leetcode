package thinking_ch4;
//https://leetcode.cn/problems/maximum-subarray/
public class N9_subarraysum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
