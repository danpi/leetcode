package hot100.Sub12_栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * hot100.Sub12_stack
 * N2_minStack
 *
 * @author hbn
 * @date 2023/10/13
 */

public class N2_minStack {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
            this.minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            this.stack.push(val);
            this.minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
