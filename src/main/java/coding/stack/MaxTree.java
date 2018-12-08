package coding.stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by chuan on 2018/10/31.
 */
public class MaxTree {
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }

    }

    // 建立node之间的关系
    public void popStacKSetMap(Stack<Node> stack,Map<Node,Node> map){
        Node pNode=stack.pop();
        if(stack.isEmpty()){
            map.put(pNode,null);
        }else{
            map.put(pNode,stack.peek());
        }

    }

    public Node getMaxTree(int[] arr){
        Node[] nArr = new Node[arr.length];
        for(int i=0;i<arr.length;i++){
            nArr[i]=new Node(arr[i]);
        }


        Stack<Node> stack = new Stack<>();
        Map<Node,Node> lBigMap = new HashMap<>();
        Map<Node,Node> rBigMap = new HashMap<>();
        for(int i=0;i<nArr.length;i++){
            Node curNode=nArr[i];
            while(!stack.isEmpty()&&stack.peek().value<curNode.value){
                popStacKSetMap(stack,lBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStacKSetMap(stack,lBigMap);
        }
        for(int i=nArr.length-1;i>=0;i--){
            Node curNode=nArr[i];
            while(!stack.isEmpty()&&stack.peek().value<curNode.value){
                popStacKSetMap(stack,rBigMap);
            }
            stack.push(curNode);
        }

        while(!stack.isEmpty()){
            popStacKSetMap(stack,rBigMap);
        }
        Node head =null;
        for(int i=0;i<nArr.length;i++){
            Node curNode=nArr[i];
            Node left=lBigMap.get(curNode);
            Node right=rBigMap.get(curNode);
            if(left==null&&right==null){
                head=curNode;
            }else if(left==null){
                if(right.left==null){
                    right.left=curNode;
                }else{
                    right.right=curNode;
                }
            }else if(right==null){
                if(left.left==null){
                    left.left=curNode;
                }else{
                    left.right=curNode;
                }
            }else{
                Node parent=left.value<right.value?left:right;
                if(parent.left==null){
                    parent.left=curNode;
                }else{
                    parent.right=curNode;
                }
            }

        }
        return head;
    }
    @Test
    public void test(){
      int[] arr  =  new int[]{3,4,5,1,2};
        MaxTree maxTree =   new MaxTree();
        System.out.println(maxTree.getMaxTree(arr).value);
    }

}
