/**
 * PACKAGE_NAME
 * main
 *
 * @author hbn
 * @date 2022/4/5
 */

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n2 = new ListNode(2);
        head.next = n2;
        ListNode n3 = new ListNode(0);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        n4.next = n2;
        ListDemo listDemo = new ListDemo();
        ListNode ret = listDemo.detectCycle(head);
        System.out.println(ret.getVal());
    }
}
