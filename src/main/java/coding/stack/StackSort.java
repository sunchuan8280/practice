package coding.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by chuan on 2018/10/27.
 */
public class StackSort {
    @Test
    public  void stackSorttest(){
         Stack<Integer> stack = new Stack<>();
         Stack<Integer> help = new Stack<>();
         stack.push(6);
         stack.push(1);
         stack.push(3);
         stack.push(2);
         stack.push(7);
         while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty()&&cur < help.peek()){
                  stack.push(help.pop());
            }
            help.push(cur);
         }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
        System.out.println(stack.toString());
    }
}
