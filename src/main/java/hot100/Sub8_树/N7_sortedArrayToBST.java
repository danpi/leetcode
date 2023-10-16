package hot100.Sub8_树;

import common.TreeNode;

/**
 * hot100.Sub8_tree
 * N7_sortedArrayToBST
 *
 * @author hbn
 * @date 2023/10/9
 */

public class N7_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }
}
