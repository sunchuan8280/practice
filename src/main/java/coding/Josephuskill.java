package coding;

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
}
