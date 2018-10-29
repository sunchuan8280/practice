package coding;



import org.junit.Test;

import java.util.Stack;

/**
 * Created by chuan on 2018/10/29.
 */
public class HanoiProblem2 {
    public static final String LM="left to mid";
    public static final String ML="mid to left";
    public static final String MR="mid to right";
    public static final String RM="right to mid";

    //记录前一项操作
    public String preAction;

    public int hanoiProblem2(int num, String x,String y,String z){
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for(int n=num;n>0;n--){
            ls.push(n);
        }
        int step=0;
        while(rs.size()!=num+1){
            //四种操作 相邻不可逆
            step += fStackToStack(HanoiProblem2.ML,HanoiProblem2.LM,ls,ms,x,y);
            step += fStackToStack(HanoiProblem2.LM,HanoiProblem2.ML,ms,ls,y,x);
            step += fStackToStack(HanoiProblem2.MR,HanoiProblem2.RM,rs,ms,z,y);
            step += fStackToStack(HanoiProblem2.RM,HanoiProblem2.MR,ms,rs,y,z);
        }
        System.out.println(rs.toString());
        return step;
    }

    /**
     * @param preNoAction 互斥操作
     * @param nowAct    当前动作
     * @param fStack
     * @param tStack
     * @param from
     * @param to
     * @return
     */
    public int fStackToStack(String preNoAction, String nowAct, Stack<Integer> fStack, Stack<Integer> tStack , String from ,String to){
        //需要满足小压大 和 相邻不可逆原则
        if(!preNoAction.equals(preAction) && fStack.peek() < tStack.peek()){
            int tmp = fStack.pop();
            tStack.push(tmp);
            preAction = nowAct;
            System.out.println("move " + tmp +" from " + from + " to " + to);
            return 1;
        }
        return 0;
    }
    @Test
    public void test(){
        HanoiProblem2 hanoiProblem2 = new HanoiProblem2();
        int step = hanoiProblem2.hanoiProblem2(10,"x","y","z");
        System.out.println("total:" + step);
    }

}
