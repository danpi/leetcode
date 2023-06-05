package framework.bfs;

import common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int depth = 1;
        while (!nodeQueue.isEmpty()) {
            int qSize = nodeQueue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (curNode.getLeft() == null || curNode.getRight() == null) {
                    return depth;
                }
                if (curNode.getLeft() != null) {
                    nodeQueue.offer(curNode.getLeft());
                }
                if (curNode.getRight() != null) {
                    nodeQueue.offer(curNode.getRight());
                }
            }
            depth++;
        }
        return depth;
    }
}

//https://leetcode.cn/problems/minimum-depth-of-binary-tree/
