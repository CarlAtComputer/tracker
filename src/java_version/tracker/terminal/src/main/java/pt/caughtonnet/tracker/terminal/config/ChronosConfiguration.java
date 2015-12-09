/**
 * 
 */
package pt.caughtonnet.tracker.terminal.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Chronos configuration
 * @author CaughtOnNet
 */
@XmlRootElement
public class ChronosConfiguration {

	
	private String instance;
	
	/**
	 * Gets the chronos instance
	 * @return the chronos instance
	 */
	@XmlElement
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
