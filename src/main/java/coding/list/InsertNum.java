package coding.list;

import coding.Node;

/**
 * 环形链表插入num
 */
public class InsertNum {

    public Node insertNum(Node head, int num) {
        if (head == null) {
            Node node = new Node(num);
            node.next = node;
            return node;
        }

        Node pre = head;
        Node cur = head.next;

        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        Node node = new Node(num);
        pre.next = node;
        node.next = cur;
        // 如果比头结点还要小，就要返回node节点
        return head.value < num ? head : node;
    }
}
