package telran.messaging.consumer;
//IlyaL-46
import telran.messaging.MessageBox;

public class Reciever extends Thread {

	MessageBox messageBox;

	public Reciever(MessageBox messageBox) {
		this.messageBox = messageBox;
		// update code - no daemon 
		setDaemon(false);
	}
	@Override
	public void run() {
		boolean running = true;
		while(running) {
			try {
				String message = messageBox.getText();
				System.out.printf("%s - %s\n", getName(), message);
			} catch (InterruptedException e) {
				running = false;
//				break;
			}
		}
	}

}
