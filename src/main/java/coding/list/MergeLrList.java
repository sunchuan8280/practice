package coding.list;

import coding.Node;
import org.junit.Test;

/**
 * 按照左右半区的方式重新组合单链表
 */
public class MergeLrList {

    public Node relocate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = head;
        Node right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
        return head;

    }

    public Node mergeLR(Node left, Node right) {
        Node next = null;
        while (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
        return left;
    }

    @Test
    public void test() {

        Node node1 = new Node(4);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node head = relocate(node1);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
