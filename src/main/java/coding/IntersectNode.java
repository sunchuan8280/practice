package coding;

/**
 * Created by chuan on 2018/12/2.
 */
public class IntersectNode {
    public Node getLoopNode(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node n1=head.next;// n1-->slow
        Node n2=head.next.next;// n2-->fast
        while(n1!=n2){
            if(n2.next==null||n2.next.next==null){
                return null;
            }
            n1=n1.next;
            n2=n2.next.next;
        }
        n2=head;// 从头再走一遍
        while(n1!=n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }
}
