package coding;

/**
 * Created by chuan on 2018/11/9.
 */
public class RemoveLastKthNode {
    public Node removeLastKthNode(Node head,int lastKth){
        if(head==null||lastKth<1){
            return null;
        }
        Node cur=head;
        while(cur!=null){
            lastKth--;
            cur=cur.next;
        }
        if(lastKth==0){//delete head node
            head=head.next;
        }

        if(lastKth<0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if(head==null||lastKth<1){
            return null;
        }
        DoubleNode cur=head;
        while(cur!=null){
            lastKth--;
            cur=cur.next;
        }
        if(lastKth==0){//delete head node
            head=head.next;
            head.last=null;
        }

        if(lastKth<0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if(cur.next.next!=null){
                cur.next.next.last=cur;
            }
        }
        return head;
    }

}
