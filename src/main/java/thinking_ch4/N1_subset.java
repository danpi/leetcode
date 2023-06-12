package thinking_ch4;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集，组合，全排列
 */
public class N1_subset {
    private List<List<Integer>> res = new LinkedList<>();

    //https://leetcode.cn/problems/subsets/
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(0, track, nums);
        return res;
    }

    private void backtrack(int start, LinkedList<Integer> track, int[] nums) {
        if (start == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        int val = nums[start];
        track.addLast(val);
        backtrack(start + 1, track, nums);
        track.removeLast();
        backtrack(start + 1, track, nums);
    }

    private List<List<Integer>> result;

    //https://leetcode.cn/problems/permutations/
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums);
        return result;
    }

    private void backtrack(LinkedList<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(track, nums);
            track.removeLast();
        }
    }

    //https://leetcode.cn/problems/combinations/
    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, 1, n, k);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int start, int n, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(track, i + 1, n, k);
            track.removeLast();
        }
    }
}
