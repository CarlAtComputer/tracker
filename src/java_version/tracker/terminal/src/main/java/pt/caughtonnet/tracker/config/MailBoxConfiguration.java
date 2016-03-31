package pt.caughtonnet.tracker.config;

/**
 * @author CaughtOnNet
 */
public class MailBoxConfiguration extends ParameterConfiguration {
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
