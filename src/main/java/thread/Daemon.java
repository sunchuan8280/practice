package thread;

import org.apache.log4j.Logger;

import utils.Sleeputils;

public class Daemon {
	private static Logger logger = Logger.getLogger(Daemon.class);
	public static void main(String[] args) {
		logger.info("sss");
		Thread thread=new Thread(new DaemonRunner(),"DaemonRunner");
		thread.setDaemon(true);
		thread.start();
	}

	static class DaemonRunner implements Runnable {

		public void run() {
			try {
				Sleeputils.second(10);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("DaemonThread finally run.");
			}
		}

	}
}
