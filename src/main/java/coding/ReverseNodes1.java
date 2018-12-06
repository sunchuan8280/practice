package coding;

import sun.plugin.dom.exception.NoModificationAllowedException;

import java.util.Stack;

/**
 * Created by chuan on 2018/12/5.
 */
public class ReverseNodes1 {

    public Node reverseNode1(Node head,int k){
        if(k<2){
            return head;
        }
        Stack<Node> stack=new Stack<>();
        Node cur=head;
        Node pre=null;
        Node next=null;
        Node newHead=head;
        int i=0;
        while(cur!=null){
            next=cur.next;
            stack.push(cur);
            if(stack.size()==k){
                pre=resign1(stack,pre,next);
                if(i==0) {
                    newHead=cur;
                }
                i++;
            }
            cur=next;
        }
        return newHead;
    }
    public Node resign1(Stack<Node> stack,Node left,Node right){
        Node cur=stack.pop();
        Node next=null;

        if(left!=null){
            left.next=cur;
        }
        while(!stack.isEmpty()){
            next=stack.pop();
            cur.next=next;
            cur=next;
        }
        next.next=right;
        return next;
    }


    public Node reverseNode2(Node head,int k){
        if(k<2){
            return head;
        }
        Node cur=head;
        Node next=null;
        Node pre=null;
        Node start=null;
        int count=1;
        while(cur!=null){
            next=cur.next;
            if(count==k){
                start=pre==null?head:pre.next;
                head=pre==null?cur:head;
                resign2(pre,next,start,cur);
                pre=start;
                count=0;
            }
            count++;
            cur=next;
        }
        return head;
    }

    public void resign2(Node left,Node right,Node start,Node end){
          Node pre=start;
          Node cur=start.next;
          Node next=null;
          while(cur!=right){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
          }
            if(left!=null){
              left.next=end;
            }
            start.next=right;


    }
}
