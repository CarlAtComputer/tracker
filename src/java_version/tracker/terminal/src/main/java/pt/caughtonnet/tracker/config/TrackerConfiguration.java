/**
 * 
 */
package pt.caughtonnet.tracker.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Tracker configuration
 * @author CaughtOnNet
 */
public class TrackerConfiguration {

	final static Logger logger = Logger.getLogger(new Throwable().getStackTrace()[0].getClassName());
	
	private static final String DEFAULT_TRACKER_CONFIGURATION_FILE = "config.json";


	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	
	private ChronosConfiguration chronos;
	
	private SnapShooterConfiguration snapShooter;
	
	private ClerkConfiguration clerk;
	
	private MailBoxConfiguration mailbox;
	
	private static String trackerConfigurationFile;
	
	/**
	 * Gets the chronos
	 * @return the chronos
	 */
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
	 * Gets the clerk
	 * @return the clerk
	 */
	public ClerkConfiguration getClerk() {
		return clerk;
	}
	
	/**
	 * Sets the clerk
	 * @param clerk the clerk to set
	 */
	public void setClerk(ClerkConfiguration clerk) {
		this.clerk = clerk;
	}
	
	/**
	 * Gets the mailbox
	 * @return the mailbox
	 */
	public MailBoxConfiguration getMailbox() {
		return mailbox;
	}
	
	/**
	 * Sets the mailbox
	 * @param mailbox the mailbox to set
	 */
	public void setMailbox(MailBoxConfiguration mailbox) {
		this.mailbox = mailbox;
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
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting().setDateFormat(DATE_FORMAT);
		Gson gson = builder.create();
		String saveFileLoc = getTrackerConfigurationFile();
		try (FileWriter w = new FileWriter(new File(saveFileLoc == null ? DEFAULT_TRACKER_CONFIGURATION_FILE : saveFileLoc))) {
			w.write(gson.toJson(this));
		} catch (Exception e) {
			logger.error("An error occurred while saving the configuration", e);
			throw e;
		}
	}
	
	/**
	 * Persists the current configuration on disk 
	 * @throws Exception 
	 */
	public static TrackerConfiguration load() throws Exception {
		Reader reader;
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String savedConfigFileLocation = getTrackerConfigurationFile();
		String configFileLocation = savedConfigFileLocation == null ? DEFAULT_TRACKER_CONFIGURATION_FILE : savedConfigFileLocation;
		
		File configFile = new File(configFileLocation);
		
		if (configFile.exists()) {
			reader = new FileReader(configFile);
		} else {
			logger.trace("Configuration file not found on disk, trying as a classpath resource");
			
			InputStream is = TrackerConfiguration.class.getClassLoader().getResourceAsStream(configFileLocation);
			if (is == null) {
				throw new FileNotFoundException(configFile.getAbsolutePath());
			}
			
			reader = new InputStreamReader(is);
			logger.trace("Configuration file found on classpath: " + configFileLocation);
		}
		
		try {
			return gson.fromJson(reader, TrackerConfiguration.class);
		} catch (Exception e) {
			logger.error("An error occurred while loading the configuration", e);
			throw e;
		} finally {
			reader.close();
		}
	}
}
