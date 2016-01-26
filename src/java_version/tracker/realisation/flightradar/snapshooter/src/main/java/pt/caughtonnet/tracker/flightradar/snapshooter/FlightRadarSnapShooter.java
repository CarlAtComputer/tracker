/**
 * 
 */
package pt.caughtonnet.tracker.flightradar.snapshooter;

import java.util.Date;

import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException.SnapshooterExceptionType;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.flightradar.snapshooter.scrap.FlightRadarScrapper;
import pt.caughtonnet.tracker.impl.snapshooter.DefaultSnapShooter;

/**
 *
 * @author CaughtOnNet
 */
public class FlightRadarSnapShooter extends DefaultSnapShooter {

	/**
	 * The flight radar site scrapper
	 */
	private FlightRadarScrapper scrapper;
	
	/**
	 * Flight Radar Snap Shooter constructor
	 */
	public FlightRadarSnapShooter() {
		scrapper = new FlightRadarScrapper();
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.snapshooter.Snapshooter#shoot(java.util.Date)
	 */
	@Override
	public Snapshot shoot(Date snapshotDate) throws SnapshooterException {
		if (isSetup()) {
			return scrapper.scrap();
		}
		throw new SnapshooterException("Tryed to shoot a badly setup flight radar shooter", SnapshooterExceptionType.SHOOT);
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.impl.snapshooter.DefaultSnapShooter#setupSnapShooter()
	 */
	@Override
	protected boolean setupSnapShooter() {
		return scrapper.config();
	}

}
