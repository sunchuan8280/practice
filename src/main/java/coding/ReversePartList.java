package coding;

/**
 * Created by chuan on 2018/11/12.
 */
public class ReversePartList {
    public Node reversePart(Node head,int from,int to){
        int len=0;
        Node fpre=null;
        Node tPos=null;
        Node node1=head;
        while(node1!=null){
            len++;
            if(len==from-1){
                fpre=node1;
            }
            if(len==to+1){
                tPos=node1;
            }
            node1=node1.next;
        }
        if(from<1||from>to||to>len){
            return head;
        }
        if(fpre==null){
            node1=head;
        }else{
            node1=fpre.next;
        }
        Node node2=node1.next;
        node1.next=tPos;
        Node next=null;
        while (node2!=tPos){
            next=node2.next;
            node2.next=node1;
            node1=node2;
            node2=next;
        }
        if(fpre!=null){
            fpre.next=node1;
            return head;
        }
        return node1;
    }

}
