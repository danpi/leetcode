package thinking_ch4;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 括号合法性用栈；括号生成用回溯
 */
public class N3_generateParenthesis {
    //https://leetcode.cn/problems/valid-parentheses/submissions/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.empty() || stack.pop() != ch) {
                return false;
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }


    /**
     * 1.左括号数量>=右括号数量
     * 2.对于任意一个位置：左侧的括号中，左括号数量>=右括号数量
     */
    //https://leetcode.cn/problems/generate-parentheses/
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        backtrack(n, n, track);
        return res;
    }

    private void backtrack(int left, int right, StringBuilder track) {
        if (left < 0 || right < 0) {
            return;
        }
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        //添加左括号
        track.append('(');
        backtrack(left - 1, right, track);
        track.deleteCharAt(track.length() - 1);
        //添加右括号
        track.append(')');
        backtrack(left, right - 1, track);
        track.deleteCharAt(track.length() - 1);
    }
}
