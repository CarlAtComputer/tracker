/**
 * 
 */
package pt.caughtonnet.tracker.api.snapshooter;

import java.util.Date;

import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.model.Snapshot;

/**
 *
 * @author CaughtOnNet
 */
public interface Snapshooter {

	/**
	 * Snapshooter setup
	 * @return True if setup was successful, false otherwise
	 */
	public boolean setup() throws SnapshooterException;

	/**
	 * Snapshooter is successfully configured
	 * @return True if setup was successful, false otherwise
	 */
	public boolean isSetup() throws SnapshooterException;

	/**
	 * Shoots the datasource at a specific date and returns the snapshot result
	 * @param snapshotDate the date in which to perform the shot
	 * @return The snap shot result
	 */
	public Snapshot shoot(Date snapshotDate) throws SnapshooterException;

	/**
	 * Shoots the datasource and returns the snapshot result
	 * @return The snap shot result
	 */
	public Snapshot shoot() throws SnapshooterException;
}
