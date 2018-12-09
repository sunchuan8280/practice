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
}
