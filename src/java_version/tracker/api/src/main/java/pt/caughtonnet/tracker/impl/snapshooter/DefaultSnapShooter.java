/**
 * 
 */
package pt.caughtonnet.tracker.impl.snapshooter;

import java.util.Date;

import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;

/**
 *
 * @author CaughtOnNet
 */
public abstract class DefaultSnapShooter implements Snapshooter {

	private boolean setup;
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#setup()
	 */
	@Override
	public boolean setup() throws SnapshooterException {
		setSetup(setupSnapShooter());
		return this.setup;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#isSetup()
	 */
	@Override
	public boolean isSetup() throws SnapshooterException {
		return this.setup;
	}
	
	/**
	 * Sets the setup
	 * @param setup the setup to set
	 */
	public void setSetup(boolean setup) {
		this.setup = setup;
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#shoot()
	 */
	@Override
	public Snapshot shoot() throws SnapshooterException {
		return shoot(new Date());
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#shoot(java.util.Date)
	 */
	@Override
	public abstract Snapshot shoot(Date snapshotDate) throws SnapshooterException;
	
	/**
	 * Snapshooter setup
	 * @return True if setup was successful, false otherwise
	 * @throws SnapshooterException 
	 */
	protected abstract boolean setupSnapShooter() throws SnapshooterException;
}
