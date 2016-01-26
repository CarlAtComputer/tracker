package pt.caughtonnet.tracker.terminal.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import pt.caughtonnet.tracker.config.ChronosConfiguration;
import pt.caughtonnet.tracker.config.SnapShooterConfiguration;
import pt.caughtonnet.tracker.config.TrackerConfiguration;

/**
 * Tracker configuration test
 * @author CaughtOnNet
 */
public class TrackerConfigurationTest {
	
	@Test
	public void testTrackConfigurationSave() throws Exception {
		TrackerConfiguration config = new TrackerConfiguration();
		ChronosConfiguration chronosConfig = new ChronosConfiguration();
		chronosConfig.setInstance("pt.caughtonnet.tracker.chronos.DefaultChronos");
		Map<String, Object> defaultChronosParameters = new HashMap<String, Object>();
		defaultChronosParameters.put("rate", 1000l);
		defaultChronosParameters.put("rateDeviation", 0l);
		defaultChronosParameters.put("parallelProcesses", 10);
		defaultChronosParameters.put("startDate", new Date());
		chronosConfig.setParameters(defaultChronosParameters);
		config.setChronos(chronosConfig);
		
		SnapShooterConfiguration snapShooterConfig = new SnapShooterConfiguration();
		snapShooterConfig.setInstance("pt.caughtonnet.tracker.flightradar.snapshooter.FlightRadarSnapShooter");
		config.setSnapShooter(snapShooterConfig);
		
		config.save();
	}
	

	@Test
	@Ignore
	public void testTrackConfigurationLoad() throws Exception {
		TrackerConfiguration config = TrackerConfiguration.load();
		System.out.println(config.getChronos().getParameters().get("rate"));
		System.out.println(config.getChronos().getParameters().getClass());
	}
}
