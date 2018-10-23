package utils;

import java.util.concurrent.TimeUnit;

public class Sleeputils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static final void miles(long miles) {
        try {
            TimeUnit.MILLISECONDS.sleep(miles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
