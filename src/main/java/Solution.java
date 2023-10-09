import concurrent.printnumber.ZeroEvenOdd;

import java.util.*;

/**
 * PACKAGE_NAME
 * Solution
 *
 * @author hbn
 * @date 2022/4/13
 */

public class Solution {
    //// 设计一个数据结构（也可以认为是一个类），有这四个方法
    //inc(String key) // key 对应的 value +1；如果 key 不存在则从 0 开始 +1
    //dec(String key) // key 对应的 value -1; 如果 value 减到 0 则把 key 删掉
    //getMax() // 返回当前 value 最大的 key
    //getMin() // 返回当前 value 最小的 key


    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
