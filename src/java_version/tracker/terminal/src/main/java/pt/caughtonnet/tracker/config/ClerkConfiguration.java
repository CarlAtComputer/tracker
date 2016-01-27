package pt.caughtonnet.tracker.config;

/**
 * Clerk configuration
 * @author CaughtOnNet
 */
public class ClerkConfiguration extends ParameterConfiguration {

	private String instance;
	
	private ClerkCourierConfiguration courier;
	
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
	 * Gets the courier
	 * @return the courier
	 */
	public ClerkCourierConfiguration getCourier() {
		return courier;
	}
	
	/**
	 * Sets the courier
	 * @param courier the courier to set
	 */
	public void setCourier(ClerkCourierConfiguration courier) {
		this.courier = courier;
	}
	
}
