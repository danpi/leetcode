package exercise;


import java.util.Stack;

public class SortedStack {
    Stack<Integer> minStack;
    Stack<Integer> tmpStack;

    public SortedStack() {
        this.minStack = new Stack<>();
        this.tmpStack = new Stack<>();
    }

    public void push(int val) {
        while (!minStack.isEmpty() && minStack.peek() > val) {
            tmpStack.push(minStack.pop());
        }
        this.minStack.push(val);
        while (!tmpStack.isEmpty()) {
            minStack.push(tmpStack.pop());
        }
    }

    public void pop() {
        if (minStack.isEmpty()) {
            return;
        }
        this.minStack.pop();
    }

    public int peek() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public boolean isEmpty() {
        return minStack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.peek());
//        stack.pop();
//        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.push(1);
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}
