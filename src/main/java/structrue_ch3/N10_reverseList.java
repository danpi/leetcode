package structrue_ch3;

import common.ListNode;

//https://leetcode.cn/problems/reverse-linked-list/
public class N10_reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

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
        ListNode newHead = reverse(head.next);  //尾节点作为反转后的头结点，不需要操作，一直返回即可。
        head.next.next = head;  //添加当前节点的反向指针
        head.next = null;   //消除之前的指针
        return newHead;
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
