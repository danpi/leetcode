package structrue;

import common.TreeNode;
//https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
//https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
public class N6_longestCommonAncestor {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftRes = dfs(root.left, p, q);
        boolean rightRes = dfs(root.right, p, q);
        if ((leftRes && rightRes) || ((leftRes || rightRes) && (root.val == p.val || root.val == q.val))) {
            this.ans = root;
        }
        return leftRes || rightRes || root.val == p.val || root.val == q.val;
    }
}
