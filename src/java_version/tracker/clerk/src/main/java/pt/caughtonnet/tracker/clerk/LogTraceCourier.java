package pt.caughtonnet.tracker.clerk;

import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.caughtonnet.tracker.api.clerk.Courier;
import pt.caughtonnet.tracker.api.model.Track;

/**
 *
 */
public class LogTraceCourier implements Courier {
	final static Logger logger = LoggerFactory.getLogger(new Throwable().getStackTrace()[0].getClassName());

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Courier#dispatch(pt.caughtonnet.tracker.api.model.Track)
	 */
	@Override
	public void dispatch(Track track) {
		if (logger.isTraceEnabled())
			logger.trace("Printer courier is about to dispatch a track");
		
		if (logger.isTraceEnabled())
			logger.trace("Dispatching " + track.getId() + " " + track.getLongitude() + ", " + track.getLatitude());
		
		if (logger.isDebugEnabled())
			logger.debug("Printer dispatched " + track.getId() + " with attributes " + track.getAttributes().entrySet().stream().parallel().map(i -> i.getKey()).collect(Collectors.joining(", ")));
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Courier#dispatch(java.util.Collection)
	 */
	@Override
	public void dispatch(Collection<? extends Track> tracks) {
		for (Track track : tracks) {
			dispatch(track);
		}
	}

	@Override
	public void setup() {
		// Do nothing, just testing
	}
}
