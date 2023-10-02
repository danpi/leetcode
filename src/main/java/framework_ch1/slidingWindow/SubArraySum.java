package framework_ch1.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * framework_ch1.slidingWindow
 * SubArraySum
 *
 * @author hbn
 * @date 2023/9/26
 */
//和为K的子数组
public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = preSum[i];
            if (preSumFreq.containsKey(sum - k)) {
                count += preSumFreq.get(sum - k);
            }
            preSumFreq.put(sum, preSumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subArraySum.subarraySum(nums, 3));
    }
}
