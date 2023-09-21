package exercise;

import common.ListNode;
import common.TreeNode;
import framework_ch1.slidingWindow.CheckInclusion;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import javax.annotation.processing.SupportedSourceVersion;

public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(candidates, target, path, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, LinkedList<Integer> path, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            backtrack(candidates, target - candidates[i], path, i + 1);
            path.removeLast();
        }
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> ascStack = new Stack<>();
        int[] hs = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            hs[i + 1] = heights[i];
        }
        hs[0] = hs[heights.length + 1] = 0;
        for (int i = 0; i < hs.length; i++) {
            while (!ascStack.isEmpty() && hs[ascStack.peek()] > hs[i]) {
                int heightIndex = ascStack.pop();
                maxArea = Math.max(maxArea, hs[heightIndex] * (i - ascStack.peek() - 1));
            }
            ascStack.push(i);
        }
        return maxArea;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1, nums2Index = n - 1;
        int index = m + n - 1;
        while (nums1Index >= 0 && nums2Index >= 0) {
            if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[index--] = nums1[nums1Index--];
            } else {
                nums1[index--] = nums2[nums2Index--];
            }
        }
        while (nums2Index >= 0) {
            nums1[index--] = nums2[nums2Index--];
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> levelQ = new LinkedList<>();
        if (root == null) {
            return res;
        }
        levelQ.add(root);
        while (!levelQ.isEmpty()) {
            int sz = levelQ.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
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

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private Map<Integer, Integer> nodeIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        nodeIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeIndex.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    TreeNode buildTreeHelper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] part = prerequisites[i];
            inDegree[part[0]]++;
            adj.get(part[1]).add(part[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> adjList = adj.get(cur);
            numCourses--;
            for (int node : adjList) {
                if (--inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }
        return numCourses == 0;
    }

    public int coinChange(int[] coins, int amount) {
        int ans = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = dfs(root1.left, root2.left);
        root1.right = dfs(root1.right, root2.right);
        return root1;
    }

    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char top = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(top);
            if (sb.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countSubstrings(s, i, i);
            count += countSubstrings(s, i, i + 1);
        }
        return count;
    }

    public int countSubstrings(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     * 示例:
     *
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *
     * @param s
     * @return
     */
    private List<String> ans = new LinkedList<>();
    private boolean[] visit;

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        visit = new boolean[chars.length];
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        backtrack(chars, sb, 0);
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    void backtrack(char[] chars, StringBuilder path, int start) {
        if (path.length() == chars.length) {
            ans.add(new String(path));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visit[i] || i > 0 && !visit[i - 1] && chars[i] == chars[i - 1]) {
                continue;
            }
            visit[i] = true;
            path.append(chars[i]);
            backtrack(chars, path, i + 1);
            path.deleteCharAt(path.length() - 1);
            visit[i] = false;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode largeDummy = new ListNode(-1);
        ListNode small = smallDummy;
        ListNode large = largeDummy;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                head = head.next;
                small = small.next;
            } else {
                large.next = head;
                head = head.next;
                large = large.next;
            }
        }
        large.next = null;
        small.next = large;
        return smallDummy.next;
    }

    private static final int mod = 1000000007;

    public int waysToStep(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }

    private static final String splitIpv4 = "\\.";
    private static final String splitIpv6 = ":";
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";
    private static final String NEITHER = "Neither";

    String validIpv4(String queryIP) {
        String[] splits = queryIP.split(splitIpv4, -1);
        if (splits.length != 4) {
            return NEITHER;
        }
        for (String split : splits) {
            int ip = 0;
            if (split.length() == 0 || split.length() > 4) {
                return NEITHER;
            }
            if (split.charAt(0) == '0' && split.length() != 1) {
                return NEITHER;
            }
            for (char ch : split.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return NEITHER;
                } else {
                    int v = ch - '0';
                    ip = ip * 10 + v;
                }
                if (ip > 255) {
                    return NEITHER;
                }
            }
        }
        return IPV4;
    }

    String validIpv6(String queryIP) {
        String[] splits = queryIP.split(splitIpv6, -1);
        if (splits.length != 8) {
            return NEITHER;
        }
        for (String split : splits) {
            if (split.length() == 0 || split.length() > 4) {
                return NEITHER;
            }
            for (char ch : split.toCharArray()) {
                if (!Character.isDigit(ch) && !(Character.toLowerCase(ch) >= 'a') || !(Character.toLowerCase(ch)
                        <= 'f')) {
                    return NEITHER;
                }
            }
        }
        return IPV6;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> tuples= twoSum(nums,i+1,-nums[i]);
            for(List<Integer> tuple:tuples){
                List<Integer> ans=new ArrayList<>(tuple);
                ans.add(nums[i]);
                res.add(ans);
            }
            while(i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return res;
    }
    List<List<Integer>> twoSum(int[] nums,int start,int target){
        List<List<Integer>> ans=new LinkedList<>();
        int left=start;
        int right=nums.length-1;
        while(left<right){
            int leftv=nums[left];
            int rightv=nums[right];
            int mid=leftv+rightv;
            if(mid==target){
                ans.add(Arrays.asList(leftv,rightv));
                while(left<right&&nums[left]==leftv){
                    left++;
                }
                while(left<right&&nums[right]==rightv){
                    right--;
                }
            }else if(mid<target){
                while(left<right&&nums[left]==leftv){
                    left++;
                }
            }else if(mid>target){
                while(left<right&&nums[right]==rightv){
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        System.out.println((solution.threeSum(nums)));

    }
}