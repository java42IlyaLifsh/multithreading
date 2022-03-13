package telran.messaging;

import java.util.concurrent.locks.*;

public class MessageBox {
private String text;
private Lock monitor = new ReentrantLock();
private Condition producerWaiting = monitor.newCondition();
private Condition consumerWaiting = monitor.newCondition();
public  void setText(String text) {
	try {
		monitor.lock();
		while (this.text != null) {
			try {
				producerWaiting.await();
			} catch (InterruptedException e) {

			}
		}
		this.text = text;
		consumerWaiting.signal();
	} finally {
		monitor.unlock();
	}
}
public  String getText() throws InterruptedException {
	try {
		monitor.lock();
		while (text == null) {
			consumerWaiting.await();
		}
		String res = text;
		text = null;
		producerWaiting.signal();
		return res;
	} finally {
		monitor.unlock();
	}
}
public  String pullText() {
	monitor.lock();
	try {
		String res = text;
		text = null;
		producerWaiting.signal();
		return res;
	} finally {
		monitor.unlock();
	}
}
}
