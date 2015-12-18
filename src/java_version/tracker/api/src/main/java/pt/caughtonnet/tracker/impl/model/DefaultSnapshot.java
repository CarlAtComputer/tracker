/**
 * 
 */
package pt.caughtonnet.tracker.impl.model;

import java.util.Date;
import java.util.List;

import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.model.Track;

/**
 * @author CaughtOnNet
 *
 */
public class DefaultSnapshot implements Snapshot {

	public static final Snapshot NOK = new DefaultSnapshot(false);
	public static final Snapshot OK = new DefaultSnapshot(true);

	/**
	 * The snapshot tracks
	 */
	private List<Track> tracks;
	
	/**
	 * The snapshot date
	 */
	private Date snapDate;
	
	/**
	 * The ok status flag
	 */
	private boolean okFlag;
	
	public DefaultSnapshot() {
		this(true);
	}
	
	/**
	 * @param okFlag The ok status flag
	 */
	public DefaultSnapshot(boolean okFlag) {
		setOkFlag(okFlag);
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Snapshot#getSnapDate()
	 */
	@Override
	public Date getSnapDate() {
		return snapDate;
	}
	
	/**
	 * Sets the snapDate
	 * @param snapDate the snapDate to set
	 */
	public void setSnapDate(Date snapDate) {
		this.snapDate = snapDate;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Snapshot#getTracks()
	 */
	@Override
	public List<Track> getTracks() {
		return tracks;
	}
	
	/**
	 * Sets the tracks
	 * @param tracks the tracks to set
	 */
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	/**
	 * Sets the okFlag
	 * @param okFlag the okFlag to set
	 */
	public void setOkFlag(boolean okFlag) {
		this.okFlag = okFlag;
	}
	
	/**
	 * Gets the okFlag
	 * @return the okFlag
	 */
	public boolean isOkFlag() {
		return okFlag;
	}

}
