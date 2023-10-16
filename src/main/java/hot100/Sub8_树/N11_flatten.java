package hot100.Sub8_树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * hot100.Sub8_tree
 * N11_flatten
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N11_flatten {
    //前序遍历
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode cur = list.get(i);
            TreeNode next = list.get(i + 1);
            cur.left = null;
            cur.right = next;
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
