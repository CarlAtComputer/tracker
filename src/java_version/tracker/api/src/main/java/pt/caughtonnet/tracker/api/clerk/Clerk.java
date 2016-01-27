package pt.caughtonnet.tracker.api.clerk;

import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;

/**
 * @author CaughtOnNet
 */
public interface Clerk<C> {
	/**
	 * Setups clerk
	 */
	public void setup(C configuration);
	
	/**
	 * Starts clerk
	 */
	public void start();
	
	/**
	 * Stops clerk
	 */
	public void stop();

	/**
	 * Sets the mailbox
	 * @param mailBox The mailbox
	 */
	public void setMailBox(TrackerMailBox mailBox);
	
	/**
	 * Sets the courier
	 * @param courier The courier
	 */
	public void setCourier(Courier courier);

	/**
	 * Get the configuration class
	 * @return The configuration class
	 */
	public Class<C> getConfigurationBean();
}
