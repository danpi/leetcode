package hot100.Sub11_二分查找;

/**
 * hot100.Sub11_binarySearch
 * N5_findMin
 *
 * @author hbn
 * @date 2023/10/13
 */

public class N5_findMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
