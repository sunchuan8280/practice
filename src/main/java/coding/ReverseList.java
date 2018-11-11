package coding;

import org.junit.Test;

/**
 * Created by chuan on 2018/11/11.
 */
public class ReverseList {
    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public DoubleNode reverseDoubleNodeList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }

    @Test
    public void test(){
        Node head1=null;

        Node node1= new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        Node node4= new Node(4);
        head1=node1;
        node1.next=node2;
        node1.next.next=node3;
        node1.next.next.next=node4;

        ReverseList reverseList=new ReverseList();
         Node h=  reverseList.reverseList(head1);
        while (h!=null){
            System.out.println(h.value);
            h=h.next;
        }
    }

}
