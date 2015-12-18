package pt.caughtonnet.tracker.api.model;

import java.util.Date;
import java.util.List;

/**
 * @author CaughtOnNet
 */
public interface Snapshot {
	public Date getSnapDate();
	public List<Track> getTracks();
}
