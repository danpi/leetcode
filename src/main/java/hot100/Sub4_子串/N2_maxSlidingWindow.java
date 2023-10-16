package hot100.Sub4_子串;

import java.util.Deque;
import java.util.LinkedList;

/**
 * hot100.Sub4_subString
 * N2_maxSlidingWindow
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N2_maxSlidingWindow {
    //维护一个queue，尾插，维持队列内降序
    //queue中队头->队尾是降序(队尾<新到的元素,需要出队)
    //队头为窗口中的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (i-deque.getFirst()>=k){  //注意，如果队列过长>k，需要将队头不断出队
                deque.pollFirst();
            }
            if (i-k+1>=0){
                ans[i-k+1]=nums[deque.getFirst()];
            }
        }
        return ans;
    }
}
