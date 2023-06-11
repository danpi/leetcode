package structrue;

import common.ListNode;

//https://leetcode.cn/problems/reverse-linked-list/
public class N10_reverseList {
    //迭代
    //https://leetcode.cn/problems/reverse-linked-list/
    ListNode reverseIter(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //https://leetcode.cn/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        //找到pre和next
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //切断left和right，使其独立
        ListNode next = rightNode.next;
        rightNode.next = null;
        pre.next = null;
        reverse(leftNode);
        //接上断点
        pre.next = rightNode;
        leftNode.next = next;
        return dummy.next;
    }

}
