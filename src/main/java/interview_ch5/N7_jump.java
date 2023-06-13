package interview_ch5;

import java.util.HashMap;
import java.util.Map;

public class N7_jump {
    //https://leetcode.cn/problems/jump-game/
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }

    //https://leetcode.cn/problems/jump-game-ii/
    //动态规划
    private Map<Integer, Integer> memo = new HashMap<>();

    public int jump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            memo.put(i, nums.length);
        }
        return dp(nums, 0);
    }

    private int dp(int[] nums, int k) {
        if (k >= nums.length - 1) {
            return 0;
        }
        if (memo.get(k) != nums.length) {
            return memo.get(k);
        }
        int step = nums[k];
        for (int i = 1; i <= step; i++) {
            int subProblem = dp(nums, k + i);
            int min = Math.min(memo.get(k), subProblem + 1);
            memo.put(k, min);
        }
        return memo.get(k);
    }

    //贪心
    public int jump2(int[] nums) {
        int n = nums.length;
        int end = 0;    //索引i起跳能到的最远距离
        int farthest = 0;   //[0...end]能到达的最远距离
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(i + nums[i], farthest);
            if (end == i) {
                count++;
                end = farthest;
            }
        }
        return count;
    }
}
