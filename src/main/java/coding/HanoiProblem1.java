package coding;


import org.junit.Test;

/**
 * Created by chuan on 2018/10/28.
 * 增加限制 不能从最左侧的塔直接移动到最右侧 也不能从最右侧直接移动到最左侧 必须经过中间
 */
public class HanoiProblem1 {
    public void move(int n, java.lang.String from , java.lang.String to){
        System.out.println("move "+n+" from "+ from + " to " +to);
    }
    public int process(int num, String left ,String mid, String right, String from, String to){
        if(num == 1){
            if(from.equals(mid) || to.equals(mid)){
                //这里只需要操作一步
                move(1,from,to);
                return 1;
            }else{
                //这里需要走两步
                move(1,from,mid);
                move(1,mid,to);
                return 2;
            }
        }else{
            if(from.equals(mid) || to.equals(mid)){//从左到中 从右到中 从中到左 从中到右
                // 第一步先将1到n-1的从from搬到辅助塔
                String help;
                if(from.equals(left)||to.equals(left)){
                    help = right;
                }else {
                    help = left;
                }

                int part1 = process(num-1,left,mid,right,from,help);
                // 第二步将n的从from搬到目标塔
                int part2 = 1;
                move(num,from,to);
                // 第二步将1到n-1的从辅助塔搬到目标塔
                int part3 = process(num-1,left,mid,right,help,to);
                return part1+part2+part3;
            }else{ // 从左到右 从右到左
                int part1 = process(num-1,left,mid,right,from,to);
                int part2 = 1;
                move(num,from,mid);
                int part3 = process(num-1,left,mid,right,to,from);
                int part4 = 1;
                move(num,mid,to);
                int part5 = process(num-1,left,mid,right,from,to);
                return part1+part2+part3+part4+part5;
            }
        }
    }

    @Test
    public void test(){
        HanoiProblem1 hanoiProblem1 = new HanoiProblem1();
        int step=hanoiProblem1.process(10,"x","y","z","x","z");
        System.out.println(step);
    }
}
