package lock;

import org.junit.Test;
import utils.Sleeputils;

import java.util.concurrent.locks.Lock;

/**
 * Created by chuan on 2018/10/14.
 */
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock =new TwinsLock();
        class Worker extends Thread{
            public void run(){
                while(true){
                    lock.lock();
                    try{
                        Sleeputils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        Sleeputils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        for(int i=0;i<10;i++){
            Worker w=new Worker();
            w.setDaemon(true);
            w.start();
        }

        for(int i=0;i<10;i++){
            Sleeputils.second(1);
            System.out.println();
        }



    }


}
