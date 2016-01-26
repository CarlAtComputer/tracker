/**
 * 
 */
package pt.caughtonnet.tracker.api.chronos;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Future;

import pt.caughtonnet.tracker.api.exception.chronos.ChronosException;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;

/**
 * The chronos contract
 * @author CaughtOnNet
 */
public interface Chronos<C> {
	
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
	 * Setup the chronos
	 * @throws ChronosException Chronos exception 
	 */
	public void setup(C configuration) throws ChronosException;
	
	/**
	 * Starts the snapshooting at the specified rate
	 */
	public void start();
	
	/**
	 * Stops the snapshooting
	 */
	public void stop();

	/**
	 * Get the configuration class
	 * @return The configuration class
	 */
	public Class<C> getConfigurationBean();
}
