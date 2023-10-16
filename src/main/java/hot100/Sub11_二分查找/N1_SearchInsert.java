package hot100.Sub11_二分查找;

/**
 * hot100.Sub11_binarySearch
 * N1_SearchInsert
 *
 * @author hbn
 * @date 2023/10/12
 */

public class N1_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
