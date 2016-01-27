package pt.caughtonnet.tracker.clerk.config;

/**
 * @author CaughtOnNet
 */
public class DefaultClerkParameters {
	/**
	 * Clerk rate
	 */
	private Double rate;

	/**
	 * Clerk rate deviation
	 */
	private Double rateDeviation;

	/**
	 * Clerk parallel process number
	 */
	private Double parallelProcesses;

	/**
	 * Gets the rate
	 * 
	 * @return the rate
	 */
	public Double getRate() {
		return rate;
	}

	/**
	 * Sets the rate
	 * 
	 * @param rate the rate to set
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}

	/**
	 * Gets the rateDeviation
	 * 
	 * @return the rateDeviation
	 */
	public Double getRateDeviation() {
		return rateDeviation;
	}

	/**
	 * Sets the rateDeviation
	 * 
	 * @param rateDeviation the rateDeviation to set
	 */
	public void setRateDeviation(Double rateDeviation) {
		this.rateDeviation = rateDeviation;
	}

	/**
	 * Gets the parallelProcesses
	 * 
	 * @return the parallelProcesses
	 */
	public Double getParallelProcesses() {
		return parallelProcesses;
	}

	/**
	 * Sets the parallelProcesses
	 * 
	 * @param parallelProcesses the parallelProcesses to set
	 */
	public void setParallelProcesses(Double parallelProcesses) {
		this.parallelProcesses = parallelProcesses;
	}

}
