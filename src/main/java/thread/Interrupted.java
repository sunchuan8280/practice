package thread;

import java.util.concurrent.TimeUnit;

public class Interrupted {

	
	static class SleepRunner implements Runnable{
		public void run(){
			while(true){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	static class BusyRunner implements Runnable{
		public void run(){
			while(true){
			
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread sleepThread=new Thread(new SleepRunner(),"SleepThread");
		sleepThread.setDaemon(true);
		
		Thread busyThread =new Thread(new BusyRunner(),"BusyThread");
		busyThread.setDaemon(true);
		
		sleepThread.start();
		busyThread.start();
		
		TimeUnit.SECONDS.sleep(5);
		
		sleepThread.interrupt();
		busyThread.interrupt();
		
		System.out.println("SleepThread interrupted is "+ sleepThread.isInterrupted());
		System.out.println("SleepThread interrupted is "+ busyThread.isInterrupted());
	}

}
