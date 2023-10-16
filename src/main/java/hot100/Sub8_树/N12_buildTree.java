package hot100.Sub8_树;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * hot100.Sub8_tree
 * N12_buildTree
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N12_buildTree {
    private Map<Integer, Integer> nodeIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            nodeIndex.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft >= preRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        int inIndex = nodeIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int lenLeft = inIndex - inLeft;
        root.left = buildTreeHelper(preorder, preLeft + 1, preLeft + 1 + lenLeft, inorder, inLeft, inIndex);
        root.right = buildTreeHelper(preorder, preLeft + 1 + lenLeft, preRight, inorder, inIndex + 1, inRight);
        return root;
    }
}
