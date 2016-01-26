/**
 * 
 */
package pt.caughtonnet.tracker.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Tracker configuration
 * @author CaughtOnNet
 */
public class TrackerConfiguration {
	
	private static final String DEFAULT_TRACKER_CONFIGURATION_FILE = "config.json";


	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	
	private ChronosConfiguration chronos;
	
	
	private SnapShooterConfiguration snapShooter;
	
	
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
			throw e;
		}
	}
	
	/**
	 * Persists the current configuration on disk 
	 * @throws Exception 
	 */
	public static TrackerConfiguration load() throws Exception {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String saveFileLoc = getTrackerConfigurationFile();
		try (Reader reader = new FileReader(new File(saveFileLoc == null ? DEFAULT_TRACKER_CONFIGURATION_FILE : saveFileLoc))) {
			return gson.fromJson(reader, TrackerConfiguration.class);
		} catch (Exception e) {
			throw e;
		}
	}
}