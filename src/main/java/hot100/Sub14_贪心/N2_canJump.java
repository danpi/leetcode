package hot100.Sub14_贪心;

/**
 * hot100.Sub14_greedy
 * N2_canJump
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N2_canJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n; i++) {
            if (farthest < i) { //最远位置<i，不能再往前跳了
                return false;
            } else {
                farthest = Math.max(farthest, nums[i] + i);
            }
            if (farthest >= n - 1) {//提前结束
                return true;
            }
        }
        return false;
    }
}
