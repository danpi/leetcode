package hot100.Sub8_tree;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * hot100.Sub8_tree
 * N13_pathSum
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N13_pathSum {
    //前缀和，挺难想的，prefixMap是为了记录前缀和的频次
    //好的解法：https://leetcode.cn/problems/path-sum-iii/solutions/596361/dui-qian-zhui-he-jie-fa-de-yi-dian-jie-s-dey6/?envType=study-plan-v2&envId=top-100-liked
    private int target;
    private Map<Integer, Integer> prefixMap;

    public int pathSum(TreeNode root, int targetSum) {
        prefixMap = new HashMap<>();
        target = targetSum;
        prefixMap.put(0, 1);
        return recursion(root, 0);
    }

    private int recursion(TreeNode node, int curSum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        curSum += node.val;
        res += prefixMap.getOrDefault(curSum - target, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);
        int left = recursion(node.left, curSum);
        int right = recursion(node.right, curSum);
        res = res + left + right;
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);
        return res;
    }
}
