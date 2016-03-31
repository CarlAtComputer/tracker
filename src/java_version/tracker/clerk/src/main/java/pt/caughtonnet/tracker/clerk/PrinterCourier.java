package pt.caughtonnet.tracker.clerk;

import java.util.Collection;

import pt.caughtonnet.tracker.api.clerk.Courier;
import pt.caughtonnet.tracker.api.model.Track;

/**
 *
 */
public class PrinterCourier implements Courier {

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Courier#dispatch(pt.caughtonnet.tracker.api.model.Track)
	 */
	@Override
	public void dispatch(Track track) {
		System.out.println("dispatching " + track.getId() + " " + track.getLongitude() + ", " + track.getLatitude());
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
