package coding;

import org.junit.Test;

/**
 * Created by chuan on 2018/11/12.
 */
public class ReversePartList {
    public Node reversePart(Node head,int from,int to){
        int len=0;
        Node fpre=null;
        Node tPos=null;
        Node node=head;
        // 先找到需要翻转的前一个节点和后一个节点
        while(node!=null){
            len++;
            if(len==from-1){
                fpre=node;
            }
            if(len==to+1){
                tPos=node;
            }
            node=node.next;
        }

        if(from<1||from>to||to>len){
            return head;
        }
        //判断是否翻转里有没有头节点，fre==null有
        if(fpre==null){
            node=head;
        }else{
            node=fpre.next;
        }
        Node tmp=node;
        Node node2=node.next;
        Node next=null;
        while (node2!=tPos){
            next=node2.next;
            node2.next=node;
            node=node2;
            node2=next;
        }
        // 链接
        tmp.next=tPos;

        if(fpre!=null){
            fpre.next=node;
            return head;
        }else{
            return node;
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
        ReversePartList reversePartList=new ReversePartList();
        Node head= reversePartList.reversePart(head1,2,3);
    }
}
