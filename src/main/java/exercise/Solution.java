package exercise;

import common.ListNode;
import common.TreeNode;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int fullCountNodes(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return (int) Math.pow(2, height) - 1;
    }

    public int bstCountNodes(TreeNode root) {
        TreeNode left = root, right = root;
        int hLeft = 0, hRight = 0;
        while (left != null) {
            left = root.left;
            hLeft++;
        }
        while (right != null) {
            right = right.right;
            hRight++;
        }
        if (hLeft == hRight) {
            return (int) Math.pow(2, hLeft) - 1;
        }
        return 1 + bstCountNodes(root.left) + bstCountNodes(root.right);
    }

}