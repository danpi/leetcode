package structrue_ch3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sliding {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k + 1 < 0) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                res.add(queue.max());
                queue.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    class MonotonicQueue {
        private LinkedList<Integer> q = new LinkedList<>();

        public void push(int val) {
            while (!q.isEmpty() && q.getFirst() < val) {
                q.pop();
            }
            q.addLast(val);
        }

        public void pop(int val) {
            if (val == q.getFirst()) {
                q.pollFirst();
            }
        }

        public int max() {
            return q.getFirst();
        }
    }
}
