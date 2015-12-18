package pt.caughtonnet.tracker.api.model;

import java.io.Serializable;
import java.util.Map;

/**
 * @author CaughtOnNet
 */
public interface Track {
	public Double getLatitude();
	public Double getLongitude();
	public Double getAltitude();
	public Double getHeading();
	public Double getSpeed();
	public Serializable getId();
	public Map<String, Serializable> getAttributes();
}
