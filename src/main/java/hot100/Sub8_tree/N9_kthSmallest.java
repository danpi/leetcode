package hot100.Sub8_tree;

import common.TreeNode;

import java.util.*;

/**
 * hot100.Sub8_tree
 * N9_kthSmallest
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N9_kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
