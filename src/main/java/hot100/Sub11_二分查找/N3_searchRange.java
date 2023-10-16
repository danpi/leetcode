package hot100.Sub11_二分查找;

/**
 * hot100.Sub11_binarySearch
 * N3_searchRange
 *
 * @author hbn
 * @date 2023/10/12
 */

public class N3_searchRange {
    //只找到左边界，然后遍历得到右边界的做法，极端情况复杂度是O(n)，所以pass掉那种思路。
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    //分别找到左右边界
    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                if (isLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (isLeft) {
            return left;
        } else {
            return right;
        }
    }
}
