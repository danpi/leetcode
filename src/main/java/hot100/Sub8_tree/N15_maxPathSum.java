package hot100.Sub8_tree;

import common.TreeNode;

import java.util.PrimitiveIterator;

/**
 * hot100.Sub8_tree
 * N15_maxPathSum
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N15_maxPathSum {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    //前缀和
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        ans = Math.max(ans, root.val);
        ans = Math.max(ans, root.val + left);
        ans = Math.max(ans, root.val + right);
        ans = Math.max(ans, root.val + left + right);
        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
