package telran.messaging.controller;
//IlyaL-46
import java.util.List;
import java.util.stream.Stream;

import telran.messaging.MessageBox;
import telran.messaging.consumer.Reciever;
import telran.messaging.producer.Sender;

public class SenderRecieverAppl {

	private static final int N_MESSAGES = 20;
	private static final int N_RECIEVERS = 10;

	public static void main(String[] args) throws InterruptedException {
		final MessageBox messageBox = new MessageBox();
		Sender sender = new Sender(messageBox, N_MESSAGES);
		List<Reciever> recievers = Stream.generate(() -> new Reciever(messageBox))
				.limit(N_RECIEVERS).toList();
		recievers.forEach(Reciever::start);
		sender.start();
//		Thread.sleep(100);
		recievers.forEach(thr -> thr.interrupt());
		

	}

}
