import framework.bfs.OpenLock;
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

        OpenLock lock = new OpenLock();
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        System.out.println(lock.openLock(deadends,"0202"));
    }
}
