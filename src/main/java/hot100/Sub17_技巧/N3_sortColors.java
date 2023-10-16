package hot100.Sub17_技巧;

/**
 * hot100.Sub17_skill
 * N3_sortColors
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N3_sortColors {
    //p0记录0当前的偏移，p2记录2的偏移，当i>p2时，遍历结束
    //num[i]==0,swap(i,p0),p0++;
    //num[i]==2,swap(i,p2),p2--;但是有可能nums[p2]本身==2，所以需要加一个while循环
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
