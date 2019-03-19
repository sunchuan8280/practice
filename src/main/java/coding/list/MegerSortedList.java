package coding.list;

import coding.Node;
import org.junit.Test;

/**
 * 合并两个有序链表
 */
public class MegerSortedList {
    public Node merge(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        //记录每一次较小的节点
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value < cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }

        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }


    @Test
    public void test() {

        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        Node node11 = new Node(2);
        Node node22 = new Node(5);
        Node node33 = new Node(7);
        Node node44 = new Node(8);

        node11.next = node22;
        node22.next = node33;
        node33.next = node44;


        Node head = merge(node1, node11);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
