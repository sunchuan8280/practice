package jvm;

/**
 * Created by chuan on 2018/6/4.
 */
public class TestAllocation {
private static final int _1MB = 1024*1024;
public static void main(String[] args){
   while(true) {
       try {
           Thread.sleep(1000);
           System.out.print(args[0]);
       }catch (InterruptedException e){
            e.printStackTrace();
       }
   }
}

}
