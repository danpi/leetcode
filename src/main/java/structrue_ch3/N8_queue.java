package structrue_ch3;

import java.util.LinkedList;

/**
 * 单调队列解决滑动窗口问题
 */
//https://leetcode.cn/problems/sliding-window-maximum/submissions/
public class N8_queue {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MonotonicQueue window = new MonotonicQueue();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();

        public void push(int val) {
            while (!q.isEmpty() && q.getLast() < val) {
                q.removeLast();
            }
            q.addLast(val);
        }

        public int max() {
            return q.getFirst();
        }

        public void pop(int val) {
            if (val == q.getFirst()) {
                q.removeFirst();
            }
        }
    }
}
