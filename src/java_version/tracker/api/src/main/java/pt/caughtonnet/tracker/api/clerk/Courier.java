package pt.caughtonnet.tracker.api.clerk;

import java.util.Collection;

import pt.caughtonnet.tracker.api.model.Track;

/**
 * The courier that will dispatch the Track
 * @author CaughtOnNet
 */
public interface Courier {
	public void dispatch(Track track);
	public void dispatch(Collection<? extends Track> tracks);
}
