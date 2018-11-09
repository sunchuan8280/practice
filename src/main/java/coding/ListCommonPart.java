package coding;

import org.junit.Test;

/**
 * Created by chuan on 2018/11/7.
 */
public class ListCommonPart {
    public void printListCommonPart(Node head1,Node head2){
        while(head1!=null&&head2!=null){
            if(head1.value<head2.value){
                head1=head1.next;
            }else if(head1.value>head2.value){
                head2=head2.next;
            }else {
                System.out.println(head1.value);
                head1=head1.next;
                head2=head2.next;

            }
        }
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

        Node node22= new Node(2);
        Node node23= new Node(3);
        Node node24= new Node(4);
        Node head2=node22;
        head2.next=node22;
        node22.next=node23;
        node23.next=node24;

        new ListCommonPart().printListCommonPart(head1,head2);
    }
}
