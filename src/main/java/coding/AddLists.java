package coding;

import java.util.Stack;

/**
 * 两个单链表生成相加链表
 * Created by chuan on 2018/11/24.
 */
public class AddLists {
    /**
     * 时间和空间复杂度都是O(n)
     * @param head1
     * @param head2
     * @return
     */
    public Node addLists1(Node head1,Node head2){
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(head1!=null){
            s1.push(head1.value);
            head1=head1.next;
        }
        while(head2!=null){
            s1.push(head2.value);
            head2=head2.next;
        }
        int ca=0;
        int n1=0;
        int n2=0;
        int n=0;
        Node node =null;
        Node pre=null;
        while(!s1.isEmpty()||!s2.isEmpty()){
            n1=s1.isEmpty()?0:s1.pop();
            n2=s2.isEmpty()?0:s2.pop();
            n=n1+n2+ca;
            node=new Node(n%10);
            ca=n/10;
            pre=node;
            node.next=pre;
        }
        if(ca==1){
            pre=node;
            node=new Node(1);
            node.next=pre;
        }
        return node;

    }

    public Node addLists1(Node head1,Node head2){
        head1=reverseList(head1);
        head2=reverseList(head2);
        int ca=0;
        int n1=0;
        int n2=0;
        int n=0;
        Node c1=head1;
        Node c2=head2;
        Node pre=null;
        Node node=null;
        while (c1!=null||c2!=null){
            n1=c1==null?0:c1.value;
            n2=c2==null?0:c2.value;

            n=n1+n2+ca;
            ca=n/10;
            pre=node;
            node=new Node(n%10);
            node.next=pre;
            c1=c1==null?null:c1.next;
            c2=c2==null?null:c2.next;
        }
        if(ca==1){
            pre=node;
            node=new Node(1);
            node.next=pre;
        }

        reverseList(head1);
        reverseList(head2);
        return node;
    }
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
}
