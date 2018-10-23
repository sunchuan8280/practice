package thread;

import utils.Sleeputils;

public class Threadstate {

	static class Timewaiting implements Runnable {
		public void run() {
			while (true) {
				Sleeputils.second(100);
			}
		}
	}

	static class Waiting implements Runnable {

		public void run() {
			while (true) {
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

		static class Blocked implements Runnable {

			public void run() {
				synchronized (Blocked.class) {
					while (true) {
						Sleeputils.second(100);
					}
				}

			}

			public static void main(String[] args) {
				new Thread(new Timewaiting(), "TimewaitingThread").start();
				new Thread(new Waiting(), "WaitingThread").start();

				new Thread(new Blocked(), "BlockedThread-1").start();
				new Thread(new Blocked(), "BlockedThread-2").start();
			}
		}
	}

}
