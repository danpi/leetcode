package hot100.Sub4_子串;

import java.util.HashMap;
import java.util.Map;

/**
 * hot100.Sub4_subString
 * N1_subarraySum
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N1_subarraySum {
    //前缀和presum，并生成Map维护<前缀和,频次>
    //
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
}
