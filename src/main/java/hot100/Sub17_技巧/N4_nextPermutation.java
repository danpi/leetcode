package hot100.Sub17_技巧;

/**
 * hot100.Sub17_skill
 * N4_nextPermutation
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N4_nextPermutation {
    //从后向前找到相邻升序对(i,j),此时[j,end)肯定是降序
    //[j,end)中从后向前找到第一个k, n[i]<n[k]
    //交换i,k， 此时[j,end)为降序，改为升序即可
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int i = n - 2, j = n - 1, k = n - 1;
        while (i >= 0 && nums[i] >= nums[j]) {//找到（i，j）
            i--;
            j--;
        }
        if (i >= 0) {//不是全部降序,寻找k
            while (nums[i] >= nums[k]) {//找到k
                k--;
            }
            swap(nums, i, k);//交换i,k
        }
        reverse(nums, j, n - 1);//reverse降序区间，使结果尽可能的小
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
