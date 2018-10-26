package coding;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by chuan on 2018/10/26.
 */
public class ReverseStack  {
    Stack<Integer> stack;
    public ReverseStack(){
        stack=new Stack<>();
    }
    public int getAndRemoveLastElement(){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last=getAndRemoveLastElement();
            //不是最后一个取完还要放回去，否则丢了
            stack.push(result);
            return last;
        }
    }

    public void reverse(){
        if(stack.isEmpty()){
            return;
        }
        int last=getAndRemoveLastElement();
        reverse();
        stack.push(last);
    }

    public void push(int i){
        stack.push(i);
    }
    public void pop(){
        stack.pop();
    }

    public String toString(){
       return stack.toString();
    }
    @Test
    public void test(){
        ReverseStack reverseStack=new ReverseStack();
        reverseStack.push(1);
        reverseStack.push(2);
        reverseStack.push(3);
        reverseStack.reverse();
        System.out.println(reverseStack.toString());
    }
}
