/**
 * 
 */
package pt.caughtonnet.tracker.terminal;

import pt.caughtonnet.tracker.api.chronos.Chronos;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;
import pt.caughtonnet.tracker.terminal.config.ChronosConfiguration;
import pt.caughtonnet.tracker.terminal.config.SnapShooterConfiguration;
import pt.caughtonnet.tracker.terminal.config.TrackerConfiguration;

/**
 * @author CaughtOnNet
 */
public class Terminal {

	public static void main(String[] args) throws Exception {
//		TrackerConfiguration config = new TrackerConfiguration();
//		ChronosConfiguration chronosConfig = new ChronosConfiguration();
//		chronosConfig.setInstance("pt.caughtonnet.tracker.chronos.DefaultChronos");
//		config.setChronos(chronosConfig);
//		
//		SnapShooterConfiguration snapShooterConfig = new SnapShooterConfiguration();
//		snapShooterConfig.setInstance("pt.caughtonnet.tracker.snapshooter.DefaultSnapShooter");
//		config.setSnapShooter(snapShooterConfig);
//		
//		config.save();
		
		TrackerConfiguration config = TrackerConfiguration.load();
		
		Class<?> snapshooterClazz = Class.forName(config.getSnapShooter().getInstance());
		Snapshooter snapshooter =  (Snapshooter) snapshooterClazz.newInstance();
		
		Class<?> chonosClazz = Class.forName(config.getChronos().getInstance());
		Chronos chronos = (Chronos) chonosClazz.newInstance();
		
		chronos.setChronosSnapshooter(snapshooter);
		chronos.start();
		
		//TrackerConfiguration configuration = readConfiguration();
		//Chronos chronos = findC
	}
}
