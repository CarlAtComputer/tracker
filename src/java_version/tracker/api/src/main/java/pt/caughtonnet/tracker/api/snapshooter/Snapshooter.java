/**
 * 
 */
package pt.caughtonnet.tracker.api.snapshooter;

import java.util.Date;

import pt.caughtonnet.tracker.api.model.SnapshotResult;

/**
 *
 * @author CaughtOnNet
 */
public interface Snapshooter {

	/**
	 * Shoots the datasource at a specific date and returns the snapshot result
	 * @param snapshotDate the date in which to perform the shot
	 * @return The snap shot result
	 */
	public SnapshotResult shoot(Date snapshotDate);

	/**
	 * Shoots the datasource and returns the snapshot result
	 * @return The snap shot result
	 */
	public SnapshotResult shoot();
}
