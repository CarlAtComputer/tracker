package pt.caughtonnet.tracker.api.mailbox;

import java.util.concurrent.Future;

import pt.caughtonnet.tracker.api.model.Snapshot;

/**
 * Tracker mail box
 * @author CaughtOnNet
 */
public interface TrackerMailBox {
	/**
	 * Queues a snapshot
	 * @param snapshoot The snapshot to queue
	 */
	public boolean queueSnapshoot(Future<Snapshot> snapshoot);

	/**
	 * Waits for the top snapshot to be completed and takes it
	 * @return The top snapshot
	 */
	public Snapshot retrieveSnapshot();
	
	/**
	 * Takes the top snapshot
	 * @return The top snapshot
	 */
	public Future<Snapshot> takeSnapshot();
	
	/**
	 * Sets the mailbox capacity
	 * @param capacity
	 */
	public void setCapacity(int capacity);
	
	/**
	 * Sets up the mailbox
	 */
	public void setup();

	/**
	 * Mailbox have been setup already
	 * @return true if is setup, false otherwise
	 */
	public boolean isSetup();

	/**
	 * Gets the mailbox size
	 * @return The mailbox size
	 */
	public Integer getSize();
}
