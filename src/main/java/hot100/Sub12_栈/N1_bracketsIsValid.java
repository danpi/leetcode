package hot100.Sub12_栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * hot100.Sub12_stack
 * N1_bracketsIsValid
 *
 * @author hbn
 * @date 2023/10/13
 */

public class N1_bracketsIsValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (Character ch : s.toCharArray()) {
            if (ch.equals('(')) {
                stack.push(')');
            } else if (ch.equals('{')) {
                stack.push('}');
            } else if (ch.equals('[')) {
                stack.push(']');
            } else if (stack.isEmpty()||!stack.pop().equals(ch)) {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
