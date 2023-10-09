package hot100.Sub8_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * hot100.Sub8_tree
 * N1_N5
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N1_N5 {
    //1.二叉树的中序遍历
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    //迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            res.add(cur.val);
            root = cur.right;
        }
        return res;
    }

    //2.二叉树的最大深度
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        return Math.max(lh, rh) + 1;
    }

    //3.翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        dfsInvert(root);
        return root;
    }

    private void dfsInvert(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        dfsInvert(root.left);
        dfsInvert(root.right);
    }

    //4.对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfsSymmetric(root.left, root.right);
    }

    private boolean dfsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return dfsSymmetric(left.left, right.right) && dfsSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }

    //5.二叉树的直径
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = depth(root.left);
        int rightH = depth(root.right);
        ans = Math.max(ans, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }
}
