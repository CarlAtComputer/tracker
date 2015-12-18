/**
 * 
 */
package pt.caughtonnet.tracker.impl.snapshooter;

import java.util.Date;

import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;

/**
 *
 * @author CaughtOnNet
 */
public abstract class DefaultSnapShooter implements Snapshooter {

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#shoot(java.util.Date)
	 */
	@Override
	public abstract Snapshot shoot(Date snapshotDate);

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#shoot()
	 */
	@Override
	public Snapshot shoot() {
		return shoot(new Date());
	}
}
