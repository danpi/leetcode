package framework_ch1.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permute {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(path, nums);
        return res;
    }

    void backtrack(LinkedList<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(path, nums);
            path.removeLast();
        }
    }
}
//https://leetcode.cn/problems/permutations/
