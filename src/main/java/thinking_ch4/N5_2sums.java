package thinking_ch4;

import java.util.HashMap;
import java.util.Map;

public class N5_2sums {
    //无序，需要借助hashMap
    //https://leetcode.cn/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }


    //有序，双指针,(常量级空间，不能使用hashMap了)
    //https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSumSort(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            }
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
