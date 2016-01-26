package pt.caughtonnet.tracker.flightradar.snapshooter;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.model.Track;

/**
 * @author CaughtOnNet
 */
public class FlightRadarSnapShooterTest {

	@Test
	public void testSnapShooter() throws SnapshooterException {
		FlightRadarSnapShooter shooter = new FlightRadarSnapShooter();
		shooter.setup();
		Snapshot shot = shooter.shoot();
		List<Track> tracks = shot.getTracks();
		Assert.assertNotNull("Snapshooter returned a null set of tracks", tracks);
		for (Track track : tracks) {
			Assert.assertNotNull("A track contains null id", track.getId());
			Assert.assertNotNull("A track contains null Latitude", track.getLatitude());
			Assert.assertNotNull("A track contains null Longitude", track.getLongitude());
			Assert.assertNotNull("A track contains null Altitude", track.getAltitude());
			Assert.assertNotNull("A track contains null Attributes", track.getAttributes());
			Assert.assertNotNull("A track contains null Heading", track.getHeading());
			Assert.assertNotNull("A track contains null Speed", track.getSpeed());
		}
	}
	
}
