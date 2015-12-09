/**
 * 
 */
package pt.caughtonnet.tracker.snapshooter;

import java.util.Date;

import pt.caughtonnet.tracker.api.model.SnapshotResult;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;

/**
 *
 * @author CaughtOnNet
 */
public class DefaultSnapShooter implements Snapshooter {

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#shoot(java.util.Date)
	 */
	@Override
	public SnapshotResult shoot(Date snapshotDate) {
		System.out.println("Snapping " + snapshotDate);
		return SnapshotResult.OK;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#shoot()
	 */
	@Override
	public SnapshotResult shoot() {
		System.out.println("Snapping now");
		return SnapshotResult.OK;
	}
}
