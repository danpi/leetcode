package hot100.Sub17_技巧;

/**
 * hot100.Sub17_skill
 * N1_singleNumber
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N1_singleNumber {
    //异或
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
