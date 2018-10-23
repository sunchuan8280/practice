package DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class SimpleDateFormatTest {
    public static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        CountDownLatch c = new CountDownLatch(1);
        String date1 = "2017-07-11 12:23:00";
        String date2 = "2016-06-26 03:25:00";
        Date date11 = sf.parse(date1);
        Date date22 = sf.parse(date2);

        for (int i = 0; i < 5000; i++) {
            if (true) {
                new DateThread(date11, c, date1).start();
            } else {
                new DateThread(date22, c, date1).start();
            }
        }
        c.countDown();
    }

}

class DateThread extends Thread {
    private Date d;
    private CountDownLatch c;
    private String s;

    public DateThread(Date d, CountDownLatch c, String s) {
        this.d = d;
        this.c = c;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            c.await();
            // System.out.println(Thread.currentThread().getName() + " " +
            // SimpleDateFormatTest.sf.parse(s));
            System.out.println(Thread.currentThread().getName() + " " + SimpleDateFormatTest.sf.format(d));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
