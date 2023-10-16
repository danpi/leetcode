package hot100.Sub10_回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * hot100.Sub10_回溯
 * N4_combinationSum
 *
 * @author hbn
 * @date 2023/10/16
 */

public class N4_combinationSum {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> path=new LinkedList<>();
        backtrack(candidates,path,0,target);
        return ans;
    }
    void backtrack(int[] candidates,LinkedList<Integer> path,int start,int target){
        if (target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (target<candidates[i]){
                continue;
            }
            path.addLast(candidates[i]);
            backtrack(candidates,path,i,target-candidates[i]);
            path.removeLast();
        }
    }
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     */
}
