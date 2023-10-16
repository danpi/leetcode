package hot100.Sub2_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * hot100.Sub2_doublepointer
 * N3_threeSum
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N3_threeSum {
    //先排序，然后依次求两数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> tuple : tuples) {
                List<Integer> ans = new ArrayList<>(tuple);
                ans.add(nums[i]);
                res.add(ans);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) { //注意去除重复
                i++;
            }
        }
        return res;
    }

    List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int leftv = nums[left];
            int rightv = nums[right];
            int sum = leftv + rightv;
            if (sum == target) {
                ans.add(Arrays.asList(leftv, rightv));
                while (left < right && nums[left] == leftv) {
                    left++;
                }
                while (left < right && nums[right] == rightv) {
                    right--;
                }
            } else if (sum < target) {
                while (left < right && nums[left] == leftv) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightv) {
                    right--;
                }
            }
        }
        return ans;
    }
}
