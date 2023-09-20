package dp_ch2.subject_ch2;

import common.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class N18_rob3 {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int choose = root.val + (root.left == null ? 0 :
                rob(root.left.left) + rob(root.left.right) + (root.right == null ? 0 :
                        rob(root.right.left) + rob(root.right.right)));
        int notChoose = rob(root.left) + rob(root.right);
        int res = Math.max(choose, notChoose);
        memo.put(root, res);
        return res;
    }
}
//https://leetcode.cn/problems/house-robber-iii/
