package pt.caughtonnet.tracker.impl.model;

import java.io.Serializable;
import java.util.Map;

import pt.caughtonnet.tracker.api.model.Track;

/**
 * @author CaughtOnNet
 */
public class DefaultTrack implements Track {

	private Double latitude;
	private Double longitude;
	private Double altitude;
	private Double heading;
	private Double speed;
	private Object id;
	private Map<String, Object> attributes;
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Track#getLatitude()
	 */
	@Override
	public Double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Track#getLongitude()
	 */
	@Override
	public Double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Track#getAltitude()
	 */
	@Override
	public Double getAltitude() {
		return altitude;
	}
	
	/**
	 * Sets the altitude
	 * @param altitude the altitude to set
	 */
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Track#getHeading()
	 */
	@Override
	public Double getHeading() {
		return heading;
	}
	
	/**
	 * Sets the heading
	 * @param heading the heading to set
	 */
	public void setHeading(Double heading) {
		this.heading = heading;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Track#getSpeed()
	 */
	@Override
	public Double getSpeed() {
		return speed;
	}
	
	/**
	 * Sets the speed
	 * @param speed the speed to set
	 */
	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Track#getId()
	 */
	@Override
	public Object getId() {
		return id;
	}
	
	/**
	 * Sets the id
	 * @param id the id to set
	 */
	public void setId(Object id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.model.Track#getAttributes()
	 */
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
	/**
	 * Sets the attributes
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
