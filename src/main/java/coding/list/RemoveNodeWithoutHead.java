package coding.list;

import coding.Node;

/**
 * 给定node删除node
 */
public class RemoveNodeWithoutHead {
    public void remove(Node node) {
        if (node == null) {
            return;

        }

        Node next = node.next;
        if (next == null) {
            // 这里有问题
        }
        node.value = next.value;
        node.next = next.next;
    }

}
