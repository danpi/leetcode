package structrue_ch3;

import common.TreeNode;

/**
 * 搜索二叉树的插入，删除，节点个数
 */
public class N3_BST {
    //https://leetcode.cn/problems/insert-into-a-binary-search-tree/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    //
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode rightMin = getMin(root.right);
                root.val = rightMin.val;
                root.right = deleteNode(root.right, rightMin.val);
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    //https://leetcode.cn/problems/count-complete-tree-nodes/
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    public int fullCountNodes(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return (int) Math.pow(2, height) - 1;
    }

    //O(n)优化到了O(logn*logn)
    public int bstCountNodes(TreeNode root) {
        TreeNode left = root, right = root;
        int hLeft = 0, hRight = 0;
        while (left != null) {
            left = left.left;
            hLeft++;
        }
        while (right != null) {
            right = right.right;
            hRight++;
        }
        if (hLeft == hRight) {
            return (int) Math.pow(2, hLeft) -1;
        }
        return 1 + bstCountNodes(root.left) + bstCountNodes(root.right);
    }
}