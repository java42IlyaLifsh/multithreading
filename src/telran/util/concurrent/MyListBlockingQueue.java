package telran.util.concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyListBlockingQueue<E> implements BlockingQueue<E> {
	//TODO fields of the class
	public MyListBlockingQueue(int limit) {
		//TODO
	}

	@Override
	public E remove() {
		// TODO 
		return null;
	}

	@Override
	public E poll() {
		// TODO 
		return null;
	}

	@Override
	public E element() {
		// TODO 
		return null;
	}

	@Override
	public E peek() {
		// TODO 
		return null;
	}

	@Override
	public int size() {
		// TODO 
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO 
		return false;
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
		// TODO 

	}

	@Override
	public boolean add(E e) {
		// TODO 
		return false;
	}

	@Override
	public boolean offer(E e) {
		// TODO 
		return false;
	}

	@Override
	public void put(E e) throws InterruptedException {
		// TODO 

	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		// TODO 
		return false;
	}

	@Override
	public E take() throws InterruptedException {
		// TODO 
		return null;
	}

	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO 
		return null;
	}

	@Override
	public int remainingCapacity() {
		// TODO 
		return 0;
	}

	@Override
	public boolean remove(Object o) {
		// TODO 
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO 
		return false;
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
