package pt.caughtonnet.tracker.flightradar.snapshooter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.model.Track;
import pt.caughtonnet.tracker.flightradar.snapshooter.scrap.FlightRadarSnapshot;
import pt.caughtonnet.tracker.impl.model.DefaultTrack;
import pt.caughtonnet.tracker.impl.snapshooter.DefaultSnapShooter;

public class Dummyshooter extends DefaultSnapShooter {

	@Override
	public Snapshot shoot(Date snapshotDate) throws SnapshooterException {
		DefaultTrack track;
		List<Track> tracks = new ArrayList<Track>();
		FlightRadarSnapshot shot = new FlightRadarSnapshot();
		shot.setOkFlag(true);
		shot.setSnapDate(snapshotDate);
		for (int i = 0; i < 1000; i++) {
			track = new DefaultTrack();
			track.setAltitude(1000.0 + i);
			track.setLatitude(1.0 + i);
			track.setLongitude(1.0 + i);
			tracks.add(track);
		}
		shot.setTracks(tracks);
		return shot;
	}

	@Override
	protected boolean setupSnapShooter() {
		return true;
	}

}
