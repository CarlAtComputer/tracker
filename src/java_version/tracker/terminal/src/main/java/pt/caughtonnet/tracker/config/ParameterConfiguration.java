package pt.caughtonnet.tracker.config;

import java.util.Map;

/**
 * @author CaughtOnNet
 *
 */
public class ParameterConfiguration {
	
	private Map<String, Object> parameters;
	
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
