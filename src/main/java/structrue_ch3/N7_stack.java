package structrue_ch3;

import java.util.Stack;

/**
 * 解决了nextGreaterNumber问题
 */
public class N7_stack {
    //https://leetcode.cn/problems/next-greater-element-ii/
    //非循环
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && nums[i] >= s.peek()) {
                s.pop();
            }
            ans[i] = s.empty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return ans;
    }

    //https://leetcode.cn/problems/next-greater-element-ii/submissions/
    public int[] nextGreaterElementsCycle(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.empty() && nums[i % n] >= s.peek()) {
                s.pop();
            }
            if (i < n) {
                res[i] = s.empty() ? -1 : s.peek();
            }
            s.push(nums[i % n]);
        }
        return res;
    }

    //https://leetcode.cn/problems/daily-temperatures/
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && temperatures[i] >= temperatures[s.peek()]) {
                s.pop();
            }
            res[i] = s.empty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return res;
    }
}
