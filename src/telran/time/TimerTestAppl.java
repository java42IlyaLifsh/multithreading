package telran.time;

public class TimerTestAppl {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.setPattern("HH:mm:ss");
		timer.start();
		
		//application running imitation 
		Thread.sleep(5000);
		timer.interrupt();
		Thread.sleep(5000);
		//interrupt of itself
//		Thread.currentThread().interrupt();
//		Thread.sleep(1000000000000000000L);

	}

}
