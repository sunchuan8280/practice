package coding;

import java.util.Stack;

/**
 * Created by chuan on 2018/11/18.
 */
public class Palindrome {
    public boolean isPalindrome(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur=head;
        while(cur!=null){
            stack.push(cur.next);
            cur=cur.next;
        }
        while(head!=null){
            if(head.value!=stack.pop().value){
                return false;
            }
            head=head.next;
        }
        return true;
    }

    /**
     * 右半区反转
     * @param head
     * @return
     */
    public boolean isPalindrome3(Node head){
        if(head==null||head.next==null){
            return false;
        }
        Node n1=head;
        Node n2=head;
        while (n2.next!=null&&n2.next.next!=null){
            n1=n1.next;
            n2=n2.next.next;
        }
        //此时n1指向中间节点
        n2=n1.next;
        n1.next=null;
        Node n3=null;
        while(n2!=null){
            n3=n2.next;
            n2.next=n1;
            n2=n1;
            n1=n3;
        }
        n3=n1;// 保存最后一个节点
        n2=head;
        boolean res=true;
        while(n1!=null&&n2!=null){
            if(n1.value!=n2.value){
                res=false;
                break;
            }
            n1=n1.next;
            n2=n2.next;
        }
        n1=n3.next;
        n3.next=null;
        while(n1!=null){
            n2=n1.next;
            n1.next=n3;
            n3=n1;
            n1=n2;

        }
        return res;
    }
}
