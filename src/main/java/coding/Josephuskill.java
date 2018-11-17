package coding;

import org.junit.Test;

import javax.xml.bind.NotIdentifiableEvent;

/**
 * Created by chuan on 2018/11/16.
 * 环形单链表的约瑟夫问题
 */
public class Josephuskill {
    // O(nXm)实现
    public Node josephuskillOne(Node head,int m){
        if(head==null||head.next==head||m<1){
            return head;
        }
        Node last=head;
        while (last.next!=head){
            last=last.next;
        }
        int count=0;
        while (last!=head){
            count++;
            if(count==m){
                last.next=head.next;
                count=0;
            }else{
                last=last.next;
            }
            head=last.next;
        }
        return head;
    }
    // O(N)时间复杂度
    public Node josephuskill2(Node head,int m){
        if(head==null||head.next==head||m<1){
            return head;
        }
        Node cur=head.next;
        int size=1;
        while(cur!=head){
            size++;
            cur=cur.next;
        }
        int tmp=getLive(size,m);
        while(--tmp!=0) {
            head=head.next;
        }
        head.next=head;
        return head;
    }
    // 长度为i 被杀节点m
    // 递推式 old=(new+m-1)%i+1
    public int getLive(int i,int m){
        if(i==1){
            return 1;
        }
        return (getLive(i-1,m)+(m-1))%i+1;
    }
    @Test
    public void test(){
        Node head1=null;

        Node node1= new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        Node node4= new Node(4);
        Node node5= new Node(5);
        head1=node1;
        node1.next=node2;
        node1.next.next=node3;
        node1.next.next.next=node4;
        node1.next.next.next.next=node5;
        node5.next=head1;
        Josephuskill josephuskill = new Josephuskill();
        Node live= josephuskill.josephuskill2(head1,3);
        System.out.println(live.value);
    }
}
