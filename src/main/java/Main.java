import common.TreeNode;
import structrue_ch3.N5_codec;
import thinking_ch4.N6_nsum;

/**
 * PACKAGE_NAME
 * main
 *
 * @author hbn
 * @date 2022/4/5
 */

public class Main {
    public static void main(String[] args) {
        N6_nsum sum = new N6_nsum();
        int[] nums = new int[]{1, 3, 1, 2, 2, 3};
        System.out.println(sum.twoSum(nums, 4));

        nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(sum.threeSum(nums));
        System.out.println("nsum");
        System.out.println(sum.nSum(nums, 0));
        int x = 1000000000;
        int y = -294967296;
        System.out.println(y - x - x);
        nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(sum.fourSum(nums, -294967296));


    }
}
