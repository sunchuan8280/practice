package coding;

/**
 * Created by chuan on 2018/11/20.
 */
public class ListPartition {

    public Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        int len = 0;
        Node cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[len];
        cur = head;
        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur.next;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        int i = 0;
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];

        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                small++;
                swap(nodeArr, small, index);
                index++;
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index++);
            }
        }

    }

    public void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    /**
     * O(N)解法 且保持大小顺序
     * @param head
     * @param pivot
     * @return
     */
    public Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;

        Node eH = null;
        Node eT = null;

        Node bH = null;
        Node bT = null;

        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (next.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            }else if (next.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
            }
            //连接小的和相等的
            if(sT!=null){
                sT.next=eH;
                eT=eT==null?sT:eT;
            }
            if(eT!=null){
                eT.next=bH;
            }
            return sH!=null?sH :eH!=null?eH:bH;
        }

    }
