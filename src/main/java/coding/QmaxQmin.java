package coding;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by chuan on 2018/11/4.
 * 最大值减去最小值小于或等于num的子数组数量
 */
public class QmaxQmin {
    public int getNum(int[] arr,int num){
        if(arr==null||arr.length==0){
            return 0;
        }
        LinkedList<Integer> qmin=new LinkedList<>();
        LinkedList<Integer> qmax=new LinkedList<>();
        int i=0;
        int j=0;
        int res=0;
        while(i<arr.length){
            while(j<arr.length){
                    while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
                        qmin.pollLast();
                    }
                    qmin.addLast(j);

                    while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]){
                        qmax.pollLast();
                    }
                    qmax.addLast(j);

                    if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
                        break;
                    }
                    j++;
            }
            if(qmin.peekFirst()==i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst()==i){
                qmax.pollFirst();
            }

            res+=j-i;
            System.out.println("i===="+i+"  j===="+j);
            i++;
        }
        return res;
    }
    @Test
    public void test(){
        int[] arr=new int[]{1,3,2,7,6};
        QmaxQmin qmaxQmin=new QmaxQmin();
       int res=qmaxQmin.getNum(arr,1);
       System.out.println(res);
    }
}


