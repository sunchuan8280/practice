package threadWaitOrNotify;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import utils.Sleeputils;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();
    private static Logger logger = Logger.getLogger(WaitNotify.class);

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        public void run() {
            synchronized (lock) {
                while (flag) {
                    logger.info(Thread.currentThread() + " flag is true wait @ "
                            + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                logger.info(Thread.currentThread() + " flag is false running @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }

    static class Notify implements Runnable {
        public void run() {
            synchronized (lock) {
                logger.info(Thread.currentThread() + " hold lock notify @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                Sleeputils.second(5);
            }
            synchronized (lock) {
                logger.info(Thread.currentThread() + " hold lock again sleep @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Sleeputils.second(5);
            }
        }
    }
}
