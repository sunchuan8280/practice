package coding;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by chuan on 2018/11/2.
 */
public class MaxRec {
    public int maxRecSize(int[][] map){
        if(map==null || map.length==0||map[0].length==0){
            return 0;
        }
        int maxArea=0;
        int[] height=new int[map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                height[j] = map[i][j]==0?0:height[j]+1;
            }
            maxArea = Math.max(maxRecFromBottom(height),maxArea);

        }
        return maxArea;
    }

    /**
     * 先求每一行最大矩形面积（i-k-1）*height[j]
     * @param height
     * @return
     */
    public int maxRecFromBottom(int[] height){
        if(height==null||height.length==0){
            return 0;
        }
        int max=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<height.length;i++){
           while(!stack.isEmpty()&&height[i]<height[stack.peek()]){
                int j=stack.pop();
                int k=stack.isEmpty()?-1:stack.peek();
                int curArea=(i-k-1)*height[j];
                max=Math.max(max,curArea);
           }
            stack.push(i);
        }
        //增加一列height.length无限小触发弹栈
        while (!stack.isEmpty()){
            int j=stack.pop();
            int k=stack.isEmpty()?-1:stack.peek();
            int curArea=(height.length-k-1)*height[j];
            max=Math.max(max,curArea);
        }
        return max;
    }

    @Test
    public void test(){
        int row=3;
        int col=4;
        int[][] map=new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                map[i][j]=1;
            }
        }
        /**
         * 1 0 1 1
         * 1 1 1 1
         * 1 1 1 0
         */
        map[0][1]=0;
        map[2][3]=0;
        MaxRec maxRec = new MaxRec();
        System.out.println(maxRec.maxRecSize(map));
    }
}
