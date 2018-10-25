package coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by chuan on 2018/10/25.
 */
public class TwoStatckQueue {
    private Stack<Integer> stackPop;
    private Stack<Integer> stackPush;
    public TwoStatckQueue(){
        stackPop=new Stack<>();
        stackPush=new Stack<>();
    }

    public void add(int newNum){
        stackPush.push(newNum);
    }

    public int pop(){
        if(stackPop.isEmpty()&&stackPush.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.isEmpty()&&stackPush.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    @Test
    public void test(){
        TwoStatckQueue queue=new TwoStatckQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        Assert.assertSame(1,queue.pop());
        Assert.assertSame(2,queue.pop());
        Assert.assertSame(3,queue.pop());
        Assert.assertSame(4,queue.peek());
    }
}
