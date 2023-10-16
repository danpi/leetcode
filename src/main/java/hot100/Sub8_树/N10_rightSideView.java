package hot100.Sub8_树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * hot100.Sub8_tree
 * N10_rightSideView
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N10_rightSideView {
    //层序遍历，记录每层中的最后一个元素
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> levelQ = new LinkedList<>();
        if (root == null) {
            return res;
        }
        levelQ.add(root);
        while (!levelQ.isEmpty()) {
            int size = levelQ.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = levelQ.poll();
                if (curNode.left != null) {
                    levelQ.add(curNode.left);
                }
                if (curNode.right != null) {
                    levelQ.add(curNode.right);
                }
                if (i == size - 1) {
                    res.add(curNode.val);
                }
            }
        }
        return res;
    }
}
