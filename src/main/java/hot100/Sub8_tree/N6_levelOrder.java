package hot100.Sub8_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * hot100.N8_tree
 * N6_levelOrder
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N6_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> levelQ = new LinkedList<>();
        levelQ.add(root);
        while (!levelQ.isEmpty()) {
            int size = levelQ.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode curNode = levelQ.poll();
                level.add(curNode.val);
                if (curNode.left != null) {
                    levelQ.add(curNode.left);
                }
                if (curNode.right != null) {
                    levelQ.add(curNode.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
