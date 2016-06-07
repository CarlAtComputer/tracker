package pt.caughtonnet.tracker.snapshooter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.caughtonnet.tracker.api.config.ConfigurableElement;
import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.model.Track;
import pt.caughtonnet.tracker.impl.model.DefaultSnapshot;
import pt.caughtonnet.tracker.impl.model.DefaultTrack;
import pt.caughtonnet.tracker.impl.snapshooter.DefaultSnapShooter;
import pt.caughtonnet.tracker.snapshooter.config.DummyshooterConfiguration;

public class Dummyshooter extends DefaultSnapShooter implements ConfigurableElement<DummyshooterConfiguration> {
	final static Logger logger = LoggerFactory.getLogger(new Throwable().getStackTrace()[0].getClassName());
	
	private int amountOfTracks;

	@Override
	public Snapshot shoot(Date snapshotDate) throws SnapshooterException {
		if (logger.isTraceEnabled())
			logger.trace("Dummy shooter is about to shoot a snapshot");
		
		DefaultTrack track;
		List<Track> tracks = new ArrayList<Track>();
		DefaultSnapshot shot = new DefaultSnapshot();
		shot.setOkFlag(true);
		shot.setSnapDate(snapshotDate);
		Map<String, Object> attributes = new HashMap<String, Object>();
		for (int i = 0; i < this.amountOfTracks; i++) {
			track = new DefaultTrack();
			track.setId(i);
			track.setAltitude(1000.0 + i);
			track.setLatitude(1.0 + i);
			track.setLongitude(1.0 + i);
			attributes = new HashMap<String, Object>();
			attributes.put("Attribute one", i * 10);
			attributes.put("Attribute two", i * 20);
			track.setAttributes(attributes);
			tracks.add(track);
		}
		shot.setTracks(tracks);
		
		if (logger.isInfoEnabled())
			logger.info("Dummy shooter generated a snapshot with " + shot.getTracks().size() + " tracks for " + shot.getSnapDate());
		
		return shot;
	}

	@Override
	protected boolean setupSnapShooter() {
		return true;
	}

	@Override
	public Class<DummyshooterConfiguration> getConfigurationBean() throws Exception {
		return DummyshooterConfiguration.class;
	}

	@Override
	public void configure(DummyshooterConfiguration config) throws Exception {
		this.amountOfTracks = config.getAmountOfTracks();
	}

}
