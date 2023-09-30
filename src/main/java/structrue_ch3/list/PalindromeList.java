package structrue_ch3.list;

class ListNodeChar {
    char val;
    ListNodeChar next;

    ListNodeChar(char val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromeList {
    public static boolean isPalindrome(ListNodeChar head) {
        if (head == null || head.next == null) {
            return true;
        }
        //find the middle node of structrue_ch3.list
        ListNodeChar fast = head;
        ListNodeChar slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second part
        ListNodeChar pre = null;
        ListNodeChar cur = slow.next;
        while (cur != null) {
            ListNodeChar next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //compare
        ListNodeChar firstPart = head;
        ListNodeChar secondPart = pre;
        while (secondPart != null) {
            if (firstPart.val != secondPart.val) {
                return false;
            }
            firstPart = firstPart.next;
            secondPart = secondPart.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNodeChar n1 = new ListNodeChar('a');
        ListNodeChar n2 = new ListNodeChar('b');
        ListNodeChar n3 = new ListNodeChar('c');
        ListNodeChar n4 = new ListNodeChar('b');
        ListNodeChar n5 = new ListNodeChar('a');
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(PalindromeList.isPalindrome(n1));
    }
}
