package coding;

import com.sun.org.apache.xpath.internal.axes.NodeSequence;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chuan on 2018/12/13.
 */
public class BiTreeConvertToDoubleList {
    public Node convert1(Node head){
        Queue<Node> queue=new LinkedList<Node>();
        inOrderToQueue(head,queue);
        head=queue.poll();
        Node pre=head;
        pre.left=null;
        Node cur=null;
        while(!queue.isEmpty()){
            cur= queue.poll();
            pre.right=cur;
            cur.left=pre;
            pre=cur;
        }
        pre.right=null;
        return head;
    }

    /**
     * 中序遍历
     * @param node
     * @param queue
     */
    public void inOrderToQueue(Node node,Queue<Node> queue){
        if(node==null){
            return;
        }
        inOrderToQueue(node.left,queue);
        queue.offer(node);
        inOrderToQueue(node.right,queue);
    }

    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value=data;
        }
    }
}
