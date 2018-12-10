package coding;

import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;

import java.util.Stack;

/**
 * Created by chuan on 2018/12/10.
 */
public class RemoveValue {

    public Node removeValue1(Node head,int num){
        Stack<Node> stack=new Stack<>();
        Node cur=head;
        while (cur!=null){
            if(cur.value!=num){
                stack.push(cur);
            }
            cur=cur.next;
        }
        while (!stack.isEmpty()){
            stack.peek().next=head;
            head=stack.pop();
        }
        return head;
    }

    /**
     *找到第一个不等于num的作为头节点
     * @param head
     * @param num
     * @return
     */
    public Node removeValue2(Node head,int num){
            while(head!=null){
                if(head.value!=num){
                    break;
                }
                head=head.next;
            }
            Node pre=head;
            Node cur=head;
            while(cur!=null){
                if(cur.value==num){
                    pre.next=cur.next;
                }else{
                    pre=cur;
                }
                cur=cur.next;
            }
            return head;
    }
}
