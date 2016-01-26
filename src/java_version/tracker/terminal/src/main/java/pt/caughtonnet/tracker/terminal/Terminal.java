/**
 * 
 */
package pt.caughtonnet.tracker.terminal;

import pt.caughtonnet.tracker.api.chronos.Chronos;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;
import pt.caughtonnet.tracker.config.ChronosConfiguration;
import pt.caughtonnet.tracker.config.SnapShooterConfiguration;
import pt.caughtonnet.tracker.config.TrackerConfiguration;

/**
 * @author CaughtOnNet
 */
public class Terminal {

	public static void main(String[] args) throws Exception {
		Chronos<?> chronos = TrackerFactory.createChronos(TrackerConfiguration.load());
		chronos.start();
	}
}
