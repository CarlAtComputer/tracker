package pt.caughtonnet.tracker.config;

import java.util.Map;


/**
 * Chronos configuration
 * @author CaughtOnNet
 */
public class ChronosConfiguration {

	
	private String instance;
	
	private Map<String, Object> parameters;
	
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
	
	/**
	 * Gets the parameters
	 * @return the parameters
	 */
	public Map<String, Object> getParameters() {
		return parameters;
	}
	
	
	/**
	 * Sets the parameters
	 * @param parameters the parameters to set
	 */
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
}
