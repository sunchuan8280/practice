package thread;

/**
 * Created by chuan on 2018/6/18.
 */
public class VolatileTest {
    public static volatile int race=0;
    public static void increase(){
        race++;
    }
    private static final int THREADS_COUNT=10;
    public static void  main(String[] args){
        System.out.println(race);
        Thread[] threads =new Thread[THREADS_COUNT];
        for(int i=0;i<THREADS_COUNT;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<100;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        try {
            Thread.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(race);
    }

}
