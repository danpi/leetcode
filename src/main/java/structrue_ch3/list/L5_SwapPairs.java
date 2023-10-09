package structrue_ch3.list;

/**
 * structrue_ch3.list
 * L5_SwapPairs
 *
 * @author hbn
 * @date 2023/10/2
 */

public class L5_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head, pre = dummy;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;  //暂存下一次交换起点
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            pre = cur;  //下一轮
            cur = cur.next;
        }
        return dummy.next;
    }
}
