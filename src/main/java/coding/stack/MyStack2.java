package coding.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by chuan on 2018/10/24.
 */
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        stackData=new Stack<>();
        stackMin=new Stack<>();
    }

    public void push(int newNum){
        stackData.push(newNum);
        if(stackMin.isEmpty()){
            stackMin.push(newNum);
        }else{
            stackMin.push(newNum<=getMin()?newNum:getMin());
        }
    }
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        int value=stackData.pop();
        this.stackMin.pop();
        return value;
    }

    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }

    @Test
    public void test(){
        MyStack2 stack2=new MyStack2();
        stack2.push(6);
        stack2.push(2);
        stack2.push(1);
        stack2.push(5);
        stack2.push(4);
        stack2.push(3);

        Assert.assertSame(1,stack2.getMin());
        stack2.pop();
        stack2.pop();
        stack2.pop();
        stack2.pop();
        stack2.pop();
        Assert.assertSame(6,stack2.getMin());
    }
}
