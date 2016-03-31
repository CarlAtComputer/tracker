/**
 * 
 */
package pt.caughtonnet.tracker.api.chronos;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Future;

import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;

/**
 * The chronos contract
 * @author CaughtOnNet
 */
public interface Chronos {
	
	/**
	 * Sets the chronosSnapshooter
	 * @param chronosSnapshooter the chronosSnapshooter to set
	 */
	public void setChronosSnapshooter(Snapshooter chronosSnapshooter);
	
	/**
	 * Gets the current ordered snapshot tasks
	 * @return The current ordered snapshot tasks
	 */
	public Map<Date, Future<Snapshot>> getCurrentOrderedTasks();
	
	/**
	 * Starts the snapshooting at the specified rate
	 */
	public void start();
	
	/**
	 * Stops the snapshooting
	 */
	public void stop();

	/**
	 * Sets the mailbox
	 * @param mailBox The mailbox
	 */
	public void setMailBox(TrackerMailBox mailBox);
}
