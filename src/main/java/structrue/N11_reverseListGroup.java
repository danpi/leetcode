package structrue;

import common.ListNode;
import java.util.List;

/**
 * 找到k的start和end，执行n/k轮即可，注意最后直接返回即可（添加dummy节点）
 */
//https://leetcode.cn/problems/reverse-nodes-in-k-group/submissions/
public class N11_reverseListGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode left = pre.next;
        ListNode right = pre;
        while (right != null) {
            for (int i = 0; i < k; i++) {
                right = right.next;
                if (right == null) {
                    return dummy.next;
                }
            }
            ListNode next = right.next;
            pre.next = null;
            right.next = null;
            reverse(left);
            pre.next = right;
            left.next = next;
            //下一层
            pre = left;
            left = pre.next;
            right = pre;
        }
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

