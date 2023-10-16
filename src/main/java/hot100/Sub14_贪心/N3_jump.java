package hot100.Sub14_贪心;

/**
 * hot100.Sub14_greedy
 * N3_jump
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N3_jump {
    public int jump(int[] nums) {
        int farthest = 0;
        int levelEnd = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (levelEnd < i) { //进到下一层前，更新count和levelEnd
                count++;
                levelEnd = farthest;
            }
            farthest = Math.max(farthest, nums[i] + i);
        }
        return count;
    }
}
