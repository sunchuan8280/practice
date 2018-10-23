package thread;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import utils.RuleUtils;

public class StaticTest {
    private static CountDownLatch lat;

    public static void main(String[] args) {
        lat = new CountDownLatch(1);

        for (int i = 0; i < 100000; i++) {
            String a = UUID.randomUUID().toString();
            System.out.println("a=" + a);
            new Thread(new StaticForThread(a, a.toUpperCase())).start();
        }
        lat.countDown();
    }

    public static class StaticForThread implements Runnable {
        private String a;
        private String b;

        public StaticForThread(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public void run() {
            try {
                lat.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (!RuleUtils.getResult(a, b)) {
                System.out.println("error");
                Thread.interrupted();
            } else {
                System.out.println("success");
            }

        }
    }
}
