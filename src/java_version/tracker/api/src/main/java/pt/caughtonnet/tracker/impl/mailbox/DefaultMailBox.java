package pt.caughtonnet.tracker.impl.mailbox;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import pt.caughtonnet.tracker.api.config.ConfigurableElement;
import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.impl.mailbox.config.MailBoxConfiguration;

/**
 * @author CaughtOnNet
 */
public class DefaultMailBox extends AbstractMailBox implements ConfigurableElement<MailBoxConfiguration> {

	private Queue<Future<Snapshot>> queue;

	private String name;

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#queueSnapshoot(pt.caughtonnet.tracker.api.model.Snapshot)
	 */
	@Override
	public synchronized boolean queueSnapshoot(Future<Snapshot> snapshoot) {
		System.out.println("MAILBOX: Putting");
		if (capacity == 0 || queue.size() < capacity) {
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
		System.out.println("MAILBOX: Getting");
		Future<Snapshot> future = queue.peek();
		if (future != null && future.isDone()) {
			future = queue.poll();
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

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.impl.mailbox.AbstractMailBox#setupMailBox()
	 */
	@Override
	protected void setupMailBox() {
		queue = new ConcurrentLinkedQueue<Future<Snapshot>>();
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.config.ConfigurableElement#getConfigurationBean()
	 */
	@Override
	public Class<MailBoxConfiguration> getConfigurationBean() throws Exception {
		return MailBoxConfiguration.class;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.config.ConfigurableElement#configure(java.lang.Object)
	 */
	@Override
	public void configure(MailBoxConfiguration config) throws Exception {
		this.name = config.getName();
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#getSize()
	 */
	@Override
	public Integer getSize() {
		return queue.size();
	}

}
