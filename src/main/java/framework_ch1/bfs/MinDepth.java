package framework_ch1.bfs;

import common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> levelQ = new LinkedList<>();
        int step = 1;
        levelQ.offer(root);
        while (!levelQ.isEmpty()) {
            int sz = levelQ.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = levelQ.poll();
                if (cur.left == null && cur.right == null) {
                    return step;
                }
                if (cur.left != null) {
                    levelQ.offer(cur.left);
                }
                if (cur.right != null) {
                    levelQ.offer(cur.right);
                }
            }
            step++;
        }
        return step;
    }
}

//https://leetcode.cn/problems/minimum-depth-of-binary-tree/
