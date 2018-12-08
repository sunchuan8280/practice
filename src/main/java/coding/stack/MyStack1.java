package coding.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by chuan on 2018/10/24.
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        stackData=new Stack<>();
        stackMin=new Stack<>();
    }

    public void push(int newNum){
        stackData.push(newNum);
        if(stackMin.isEmpty()){
            stackMin.push(newNum);
        }else{
            if(newNum<=getMin()){
                stackMin.push(newNum);
            }
        }
    }
    public int pop(){
        int value=stackData.pop();
        if(value==getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        return stackMin.peek();
    }
    @Test
    public void test(){
        MyStack1 stack1=new MyStack1();
        stack1.push(6);
        stack1.push(2);
        stack1.push(1);
        stack1.push(5);
        stack1.push(4);
        stack1.push(3);

        Assert.assertSame(1,stack1.getMin());
        stack1.pop();
        stack1.pop();
        stack1.pop();
        stack1.pop();
        stack1.pop();
        Assert.assertSame(6,stack1.getMin());
    }
}
