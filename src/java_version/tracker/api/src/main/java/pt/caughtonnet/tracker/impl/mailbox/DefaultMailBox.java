package pt.caughtonnet.tracker.impl.mailbox;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;
import pt.caughtonnet.tracker.api.model.Snapshot;

/**
 * @author CaughtOnNet
 */
public class DefaultMailBox implements TrackerMailBox {

	private Queue<Future<Snapshot>> queue;

	private int capacity;

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#queueSnapshoot(pt.caughtonnet.tracker.api.model.Snapshot)
	 */
	@Override
	public synchronized boolean queueSnapshoot(Future<Snapshot> snapshoot) {
		if (capacity == 0 || queue.size() < capacity) {
			System.out.println("Adding " + queue.size());
			queue.add(snapshoot);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#takeSnapshoot()
	 */
	@Override
	public synchronized Snapshot takeSnapshot() {
		Future<Snapshot> future = queue.peek();
		if (future != null && future.isDone()) {
			future = queue.poll();
			System.out.println("Removing " + queue.size());
			try {
				return future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return null;
			} catch (ExecutionException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	/**
	 * Gets the capacity
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#setCapacity(int)
	 */
	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#setup()
	 */
	@Override
	public void setup() {
		queue = new ConcurrentLinkedQueue<Future<Snapshot>>();
	}

}
