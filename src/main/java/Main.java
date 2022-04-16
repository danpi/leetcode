import java.util.LinkedList;
import java.util.List;

/**
 * PACKAGE_NAME
 * main
 *
 * @author hbn
 * @date 2022/4/5
 */

public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = null;
        ListDemo demo = new ListDemo();
        System.out.println(demo.hasCycle(node1));
    }
}
