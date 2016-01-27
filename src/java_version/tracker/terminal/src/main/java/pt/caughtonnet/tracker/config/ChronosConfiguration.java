package pt.caughtonnet.tracker.config;

import java.util.Map;


/**
 * Chronos configuration
 * @author CaughtOnNet
 */
public class ChronosConfiguration extends ParameterConfiguration {

	
	private String instance;
	
	/**
	 * Gets the chronos instance
	 * @return the chronos instance
	 */
	public String getInstance() {
		return instance;
	}
	
	
	/**
	 * Sets the chronos instance
	 * @param instance the chronos instance to set
	 */
	public void setInstance(String instance) {
		this.instance = instance;
	}
}
