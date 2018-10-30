package coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by chuan on 2018/10/30.
 */
public class MaxWindow {
    public int[] getMaxWindow(int[] arr,int w){
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for(int i=0;i<arr.length;i++){
            while(!linkedList.isEmpty()&&arr[linkedList.peekLast()]<=arr[i]){
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            //当前下标过期了
            if(linkedList.peekFirst()== i-w){
                linkedList.pollFirst();
            }
            if(i>=w-1){
                res[index++] = arr[linkedList.peekFirst()];
            }
        }
        return res;
    }
    @Test
    public void test(){
        MaxWindow maxWindow = new MaxWindow();
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(maxWindow.getMaxWindow(arr,3)));
    }
}
