package coding.list;

import coding.Node;
import org.junit.Test;

/**
 * 链表选择排序 空间O(1) 时间O(N2)
 */
public class ListSelectionSort {

    public Node selectionSort(Node head) {
        Node tail = null;
        Node cur = head;
        Node small = null;
        Node smallpre = null;
        while (cur != null) {
            small = cur;
            smallpre = getSmallestPreNode(cur);
            // 把当前最小的节点删除
            if (smallpre != null) {
                small = smallpre.next;
                smallpre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            // 把最小的节点放到最后
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;

        }
        return head;
    }

    public Node getSmallestPreNode(Node head) {
        Node small = head;
        Node smallpre = null;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                small = cur;
                smallpre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallpre;
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

        Node head = selectionSort(node1);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
