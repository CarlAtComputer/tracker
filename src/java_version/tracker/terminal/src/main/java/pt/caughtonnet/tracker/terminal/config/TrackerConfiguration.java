/**
 * 
 */
package pt.caughtonnet.tracker.terminal.config;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Tracker configuration
 * @author CaughtOnNet
 */
@XmlRootElement(name="tracker")
public class TrackerConfiguration {
	
	private static final String DEFAULT_TRACKER_CONFIGURATION_FILE = "config.xml";

	
	private ChronosConfiguration chronos;
	
	
	private SnapShooterConfiguration snapShooter;
	
	
	private static String trackerConfigurationFile;
	
	/**
	 * Gets the chronos
	 * @return the chronos
	 */
	@XmlElement
	public ChronosConfiguration getChronos() {
		return chronos;
	}
	
	/**
	 * Sets the chronos
	 * @param chronos the chronos to set
	 */
	public void setChronos(ChronosConfiguration chronos) {
		this.chronos = chronos;
	}
	
	/**
	 * Gets the snapShooter
	 * @return the snapShooter
	 */
	@XmlElement
	public SnapShooterConfiguration getSnapShooter() {
		return snapShooter;
	}
	
	/**
	 * Sets the snapShooter
	 * @param snapShooter the snapShooter to set
	 */
	public void setSnapShooter(SnapShooterConfiguration snapShooter) {
		this.snapShooter = snapShooter;
	}
	
	/**
	 * Gets the trackerConfigurationFile
	 * @return the trackerConfigurationFile
	 */
	private static String getTrackerConfigurationFile() {
		return TrackerConfiguration.trackerConfigurationFile;
	}
	
	
	/**
	 * Sets the trackerConfigurationFile
	 * @param trackerConfigurationFile the trackerConfigurationFile to set
	 */
	public static void setTrackerConfigurationFile(String trackerConfigurationFile) {
		TrackerConfiguration.trackerConfigurationFile = trackerConfigurationFile;
	}
	
	/**
	 * Persists the current configuration on disk 
	 * @throws Exception 
	 */
	public void save() throws Exception {
		JAXBContext ctx = JAXBContext.newInstance(TrackerConfiguration.class);
		Marshaller marsh = ctx.createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		String saveFileLoc = getTrackerConfigurationFile();
		marsh.marshal(this, new File(saveFileLoc == null ? DEFAULT_TRACKER_CONFIGURATION_FILE : saveFileLoc));
	}
	
	/**
	 * Persists the current configuration on disk 
	 * @throws Exception 
	 */
	public static TrackerConfiguration load() throws Exception {
		JAXBContext ctx = JAXBContext.newInstance(TrackerConfiguration.class);
		Unmarshaller unmarsh = ctx.createUnmarshaller();
		String saveFileLoc = getTrackerConfigurationFile();
		return (TrackerConfiguration) unmarsh.unmarshal(new File(saveFileLoc == null ? DEFAULT_TRACKER_CONFIGURATION_FILE : saveFileLoc));
	}
}
