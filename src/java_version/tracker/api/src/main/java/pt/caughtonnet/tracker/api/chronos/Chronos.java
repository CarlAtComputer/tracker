/**
 * 
 */
package pt.caughtonnet.tracker.api.chronos;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Future;

import pt.caughtonnet.tracker.api.model.SnapshotResult;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;

/**
 * The chronos contract
 * @author CaughtOnNet
 */
public interface Chronos {
	
	/**
	 * Sets the rate
	 * @param rate the rate to set
	 */
	public void setRate(long rate);
	
	/**
	 * Sets the chronosMode
	 * @param chronosMode the chronosMode to set
	 */
	public void setChronosMode(ChronosMode chronosMode);
	
	/**
	 * Sets the startDate
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate);
	
	/**
	 * Sets the maxRateDeviation
	 * @param maxRateDeviation the maxRateDeviation to set
	 */
	public void setMaxRateDeviation(long maxRateDeviation);
	
	/**
	 * Sets the parallelProcessNumber
	 * @param parallelProcessNumber the parallelProcessNumber to set
	 */
	public void setParallelProcessNumber(int parallelProcessNumber);
	
	/**
	 * Sets the chronosSnapshooter
	 * @param chronosSnapshooter the chronosSnapshooter to set
	 */
	public void setChronosSnapshooter(Snapshooter chronosSnapshooter);
	
	/**
	 * Starts the snapshooting at the specified rate
	 */
	public void start();
	
	/**
	 * Stops the snapshooting
	 */
	public void stop();
	
	/**
	 * Gets the current ordered snapshot tasks
	 * @return The current ordered snapshot tasks
	 */
	public Map<Date, Future<SnapshotResult>> getCurrentOrderedTasks();
}
