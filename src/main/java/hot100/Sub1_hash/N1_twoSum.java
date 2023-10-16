package hot100.Sub1_hash;

import java.util.HashMap;
import java.util.Map;

/**
 * hot100.Sub1_hash
 * N1_twoSum
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> restMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (restMap.containsKey(nums[i])) {
                return new int[]{restMap.get(nums[i]), i};
            }
            restMap.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
