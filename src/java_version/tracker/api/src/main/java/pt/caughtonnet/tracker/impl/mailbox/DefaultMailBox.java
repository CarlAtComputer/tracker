package pt.caughtonnet.tracker.impl.mailbox;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.caughtonnet.tracker.api.config.ConfigurableElement;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.impl.mailbox.config.MailBoxConfiguration;

/**
 * @author CaughtOnNet
 */
public class DefaultMailBox extends AbstractMailBox implements ConfigurableElement<MailBoxConfiguration> {
	final static Logger logger = LoggerFactory.getLogger(new Throwable().getStackTrace()[0].getClassName());

	private Queue<Future<Snapshot>> queue;

	private String name;

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#queueSnapshoot(pt.caughtonnet.tracker.api.model.Snapshot)
	 */
	@Override
	public synchronized boolean queueSnapshoot(Future<Snapshot> snapshoot) {
		if (logger.isTraceEnabled())
			logger.trace("Queueing snapshot");
		
		if (capacity == 0 || queue.size() < capacity) {
			queue.add(snapshoot);
			return true;
		}
		
		if (logger.isInfoEnabled())
			logger.info("Mail box is full, it was not possible to queue more snapshots");
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#takeSnapshoot()
	 */
	@Override
	public synchronized Snapshot retrieveSnapshot() {
		if (logger.isTraceEnabled())
			logger.trace("Waiting and retrieving the top snapshot");
		
		Future<Snapshot> future = queue.peek();
		if (future != null && future.isDone()) {
			if (logger.isTraceEnabled())
				logger.trace("Top snapshot complete");
			
			future = queue.poll();
			try {
				return future.get();
			} catch (InterruptedException | ExecutionException e) {
				logger.error("An error occurred while getting the snapshot from the future", e);
				return null;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#takeSnapshot()
	 */
	@Override
	public Future<Snapshot> takeSnapshot() {
		if (logger.isTraceEnabled())
			logger.trace("Taking the top future snapshot");
		
		return queue.poll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.caughtonnet.tracker.impl.mailbox.AbstractMailBox#setupMailBox()
	 */
	@Override
	protected void setupMailBox() {
		queue = new ConcurrentLinkedQueue<Future<Snapshot>>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.caughtonnet.tracker.api.config.ConfigurableElement#getConfigurationBean()
	 */
	@Override
	public Class<MailBoxConfiguration> getConfigurationBean() throws Exception {
		return MailBoxConfiguration.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.caughtonnet.tracker.api.config.ConfigurableElement#configure(java.lang.Object)
	 */
	@Override
	public void configure(MailBoxConfiguration config) throws Exception {
		if (logger.isTraceEnabled())
			logger.trace("Configuring mail box");
		
		this.name = config.getName();
		

		if (logger.isTraceEnabled())
			logger.trace("Mail box " + this.name + " configured");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#getSize()
	 */
	@Override
	public Integer getSize() {
		return queue.size();
	}

}
