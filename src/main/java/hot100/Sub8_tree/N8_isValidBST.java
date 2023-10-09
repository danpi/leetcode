package hot100.Sub8_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * hot100.Sub8_tree
 * N8_isValidBST
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N8_isValidBST {
    private List<Integer> inorderList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 0; i < inorderList.size() - 1; i++) {
            if (inorderList.get(i) >= inorderList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }
}
