package pt.caughtonnet.tracker.config;

/**
 * Clerk courier configuration
 * @author CaughtOnNet
 */
public class ClerkCourierConfiguration extends ParameterConfiguration {

	private String instance;
	
	/**
	 * Gets the instance
	 * @return the instance
	 */
	public String getInstance() {
		return instance;
	}
	
	/**
	 * Sets the instance
	 * @param instance the instance to set
	 */
	public void setInstance(String instance) {
		this.instance = instance;
	}
}
