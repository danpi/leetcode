package hot100.Sub12_栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * hot100.Sub12_stack
 * N5_largestRectangleArea
 *
 * @author hbn
 * @date 2023/10/13
 */

public class N5_largestRectangleArea {
    //维护大顶栈，新来值<=栈顶,就出栈（比当前值大的都出栈）
    //这样栈顶为第一个小于当前值的数，可以找到右侧第一个小于当前值的数
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] h = new int[n + 2];
        for (int i = 0; i < n; i++) {
            h[i + 1] = heights[i];
        }
        h[0] = h[n + 1] = -1;
        Deque<Integer> stack = new LinkedList<>();
        int[] right = new int[n + 2];
        for (int i = h.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && h[i] <= h[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? h.length - 1 : stack.peek();
            stack.push(i);
        }
        int[] left = new int[n + 2];
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] <= h[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        int max = 0;
        for (int i = 1; i < h.length - 1; i++) {
            max = Math.max(max, h[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    //维护一个大顶栈，当前值<栈顶时，进行计算
    //（因为达到右边界，又因为升序排序，栈顶下面一个元素即为它的左边界）
    public int largestRectangleArea2(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int[] h = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            h[i + 1] = heights[i];
        }
        h[0] = h[heights.length + 1] = 0;
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int index = stack.pop();
                maxArea = Math.max(maxArea, h[index] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}
