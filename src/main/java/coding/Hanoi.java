package coding;

import org.junit.Test;

/**
 * Created by chuan on 2018/10/28.
 */
public class Hanoi {

    public void move(int n, String from ,String to){
        System.out.println("move "+n+" from "+ from + " to " +to);
    }

    /**
     *
     * @param n
     * @param x 出发
     * @param y 辅助
     * @param z 目的地
     */
    public void hanoi(int n, String x ,String y,String z) {
        if (n == 1) {
            move(1, x, z);
        } else {
            //把n-1从左边挪到中间
            hanoi(n - 1, x, z, y);
            //把n从左边挪到右边
            move(n, x, z);
            //把n-1从中间挪到右边
            hanoi(n - 1, y, x, z);
        }
    }
    @Test
    public void test(){
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(4,"x","y","z");
      }

}
