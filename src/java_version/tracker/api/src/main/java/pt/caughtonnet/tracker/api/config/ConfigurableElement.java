package pt.caughtonnet.tracker.api.config;

public interface ConfigurableElement<C> {
	/**
	 * Get the configuration class
	 * @return The configuration class
	 */
	public Class<C> getConfigurationBean() throws Exception;

	/**
	 * Setup the element
	 */
	public void configure(C config) throws Exception;
}
