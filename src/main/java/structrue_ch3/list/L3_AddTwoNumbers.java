package structrue_ch3.list;

public class L3_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int val = l1Value + l2Value + carry;
            carry = val >= 10 ? 1 : 0;
            val %= 10;
            prev.next = new ListNode(val);
            prev = prev.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry==1){
            prev.next=new ListNode(1);
        }
        return dummy.next;
    }
}
