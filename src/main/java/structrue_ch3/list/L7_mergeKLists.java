package structrue_ch3.list;

/**
 * structrue_ch3.list
 * L7_mergeKLists
 *
 * @author hbn
 * @date 2023/10/2
 */

public class L7_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    ListNode mergeTwoList(ListNode la, ListNode lb) {
        if (la == null || lb == null) {
            return la == null ? lb : la;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (la != null && lb != null) {
            if (la.val < lb.val) {
                cur.next = la;
                la = la.next;
            } else {
                cur.next = lb;
                lb = lb.next;
            }
            cur = cur.next;
        }
        cur.next = la == null ? lb : la;
        return dummy.next;
    }
}
