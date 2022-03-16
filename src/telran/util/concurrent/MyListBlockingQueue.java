package telran.util.concurrent;
//IlyaL-HW47
import java.util.Collection;
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyListBlockingQueue<E> implements BlockingQueue<E> {
	// fields of the class
	private Queue<E> queue = new LinkedList<>();
	private int maxQeueSize = Integer.MAX_VALUE;
	private ReentrantLock mutex = new ReentrantLock();
	private Condition produserWaiting = mutex.newCondition();
	private Condition consumerWaiting = mutex.newCondition();
	
	public MyListBlockingQueue(int limit) {
		//
		maxQeueSize = limit;
	}

	@SuppressWarnings("unused")
	private MyListBlockingQueue() {}
	
	@Override
	public E remove() {
		// 
		try {
			mutex.lock();
			return queue.remove();
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public E poll() {
		//  
		try {
			mutex.lock();
			return queue.poll();
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public E element() {
		//  
		try {
			mutex.lock();
			return queue.element();
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public E peek() {
		//   
		try {
			mutex.lock();
			return queue.peek();
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public int size() {
		// 
		try {
			mutex.lock();
			return queue.size();
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public boolean isEmpty() {
		//  
		try {
			mutex.lock();
			return queue.isEmpty();
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public Iterator<E> iterator() {
		
		return null;
	}

	@Override
	public Object[] toArray() {
		
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		return false;
	}

	@Override
	public void clear() {
		//  
		try {
			mutex.lock();
			queue.clear();
		} finally {
			mutex.unlock();
		}
	}

	private void nullValidation (Object value) {
	if (value==null) throw new NullPointerException();
}

	@Override
	public boolean add(E e) {
		// 
		nullValidation(e);
		try {
			mutex.lock();
			if (queue.size()==maxQeueSize) {
				throw new IllegalStateException();
			}
			return queue.add(e);
		} finally {
			mutex.unlock();

		}
	}

	@Override
	public boolean offer(E e) {
	// 
				nullValidation(e);
			try {
				mutex.lock();
				return queue.size()==maxQeueSize ? false : queue.add(e);
				} finally {
				mutex.unlock();
			}
	}

	@Override
	public void put(E e) throws InterruptedException {
		//
		nullValidation(e);
		try {
			mutex.lock();
			while (queue.size()==maxQeueSize) {
				produserWaiting.await();
			}
			queue.add(e);
			consumerWaiting.signal();			
			} finally {
			mutex.unlock();
		}

	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		// 
		nullValidation(e);
		try {
			mutex.lock();
			while (queue.size()==maxQeueSize) {
				if(!produserWaiting.await(timeout, unit)) return false;
			}
			queue.add(e);
			consumerWaiting.signal();
			return true;
			} finally 
		{
			mutex.unlock();
		}
	}

	@Override
	public E take() throws InterruptedException {
		// 
	try {
			mutex.lock();
			while (queue.isEmpty()) {
			consumerWaiting.await();
			}
			E item = queue.remove();
			produserWaiting.signal();
			return item;
			} finally 
		{
			mutex.unlock();
		}
	}
 
	
	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		// 
		try {
				mutex.lock();
				while (queue.isEmpty()) {
				if(!consumerWaiting.await(timeout, unit)) return null;
				}
				E item = queue.remove();
				produserWaiting.signal();
				return item;
				} finally 
			{
				mutex.unlock();
			}
	}

	@Override
	public int remainingCapacity() {
		try {
			mutex.lock();
			return maxQeueSize-queue.size();
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public boolean remove(Object o) {
		nullValidation(o);
		try {
			mutex.lock();
			return queue.remove(o);
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public boolean contains(Object o) {
		nullValidation(o);
		try {
			mutex.lock();
			return queue.contains(o);
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public int drainTo(Collection<? super E> c) {
		
		return 0;
	}

	@Override
	public int drainTo(Collection<? super E> c, int maxElements) {
		
		return 0;
	}

}
