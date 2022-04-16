import java.util.Deque;
import java.util.LinkedList;

/**
 * PACKAGE_NAME
 * RectangleArea
 *
 * @author hbn
 * @date 2022/4/8
 */

public class RectangleArea {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= k) return nums;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            //check
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
