package hot100.Sub12_栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * hot100.Sub12_stack
 * N4_dailyTemperatures
 *
 * @author hbn
 * @date 2023/10/13
 */

public class N4_dailyTemperatures {
    //维护小顶栈，即新来的元素>=栈顶，就出栈（比当前值小的都出栈）；小才入栈
    //这些每次出完栈的栈顶值都大于新来的值，即右侧第一个大于的值。
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int n = temperatures.length;
        int[] nextGreater = new int[n];
        nextGreater[n - 1] = 0;
        stack.push(n-1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return nextGreater;
    }
}
