package thinking_ch4;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.cn/problems/maximum-subarray/
public class N9_subarraysum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
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

    public int subarraySumOpt(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int count = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            sumCount.put(preSum[i + 1], sumCount.getOrDefault(preSum[i + 1], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int sum0_j = preSum[i + 1] - k;
            if (sumCount.containsKey(sum0_j)) {
                count += sumCount.get(sum0_j);
            }
        }
        return count;
    }
}
