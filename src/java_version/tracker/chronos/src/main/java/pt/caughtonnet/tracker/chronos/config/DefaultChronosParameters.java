package pt.caughtonnet.tracker.chronos.config;

import java.util.Date;

/**
 * @author CaughtOnNet
 */
public class DefaultChronosParameters {

	/**
	 * Chronos rate 
	 */
	private Double rate;
	
	/**
	 * Chronos rate deviation
	 */
	private Double rateDeviation;
	
	/**
	 * Chronos parallel process number
	 */
	private Double parallelProcesses;

	/**
	 * The start date
	 */
	private Date startDate;

	/**
	 * The mailbox limit
	 */
	private Integer mailBoxLimit;
	
	/**
	 * Gets the rate
	 * @return the rate
	 */
	public Double getRate() {
		return rate;
	}
	
	/**
	 * Sets the rate
	 * @param rate the rate to set
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	/**
	 * Gets the rateDeviation
	 * @return the rateDeviation
	 */
	public Double getRateDeviation() {
		return rateDeviation;
	}
	
	/**
	 * Sets the rateDeviation
	 * @param rateDeviation the rateDeviation to set
	 */
	public void setRateDeviation(Double rateDeviation) {
		this.rateDeviation = rateDeviation;
	}
	
	/**
	 * Gets the parallelProcesses
	 * @return the parallelProcesses
	 */
	public Double getParallelProcesses() {
		return parallelProcesses;
	}
	
	/**
	 * Sets the parallelProcesses
	 * @param parallelProcesses the parallelProcesses to set
	 */
	public void setParallelProcesses(Double parallelProcesses) {
		this.parallelProcesses = parallelProcesses;
	}
	
	/**
	 * Gets the startDate
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Sets the startDate
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the mailBoxLimit
	 * @return the mailBoxLimit
	 */
	public Integer getMailBoxLimit() {
		return mailBoxLimit;
	}

	/**
	 * Sets the mailBoxLimit
	 * @param mailBoxLimit the mailBoxLimit to set
	 */
	public void setMailBoxLimit(Integer mailBoxLimit) {
		this.mailBoxLimit = mailBoxLimit;
	}
	
	
}
