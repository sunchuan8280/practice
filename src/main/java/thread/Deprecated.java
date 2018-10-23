package thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import utils.Sleeputils;

public class Deprecated {
	private static Logger logger = Logger.getLogger(Deprecated.class);
	public static void main(String[] args) throws InterruptedException {
		DateFormat format=new SimpleDateFormat("HH:mm:ss");
		Thread printThread=new Thread(new Runner(),"printThread");
		printThread.setDaemon(true);
		printThread.start();
		TimeUnit.SECONDS.sleep(3);
		printThread.suspend();
		logger.info("main suspend PrintThread at "+ format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		
		printThread.resume();
		logger.info("main resume PrintThread at "+ format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		
		printThread.stop();
		logger.info("main stop PrintThread at "+ format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		

	}

	static class Runner implements Runnable{
		public void run(){
			DateFormat format=new SimpleDateFormat();
			while(true){
				logger.info(Thread.currentThread().getName()+" Run at "+format.format(new Date()));
				Sleeputils.second(1);
			}
			
		}
	}
	
}
