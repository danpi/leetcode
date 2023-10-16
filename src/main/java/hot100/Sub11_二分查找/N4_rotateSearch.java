package hot100.Sub11_二分查找;

/**
 * hot100.Sub11_binarySearch
 * N4_rotateSearch
 *
 * @author hbn
 * @date 2023/10/13
 */

public class N4_rotateSearch {
    public int rotateSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {//如果target在左侧，那么去左侧搜索，否则搜索右侧
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {//后半部分有序
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
