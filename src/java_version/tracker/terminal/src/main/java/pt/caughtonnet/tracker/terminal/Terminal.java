/**
 * 
 */
package pt.caughtonnet.tracker.terminal;

import pt.caughtonnet.tracker.api.chronos.Chronos;
import pt.caughtonnet.tracker.api.clerk.Clerk;
import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;
import pt.caughtonnet.tracker.config.TrackerConfiguration;

/**
 * @author CaughtOnNet
 */
public class Terminal {

	public static void main(String[] args) throws Exception {
		TrackerConfiguration config = TrackerConfiguration.load();
		TrackerMailBox mailBox = TrackerFactory.createMailBox(config);
		Chronos chronos = TrackerFactory.createChronos(mailBox, config);
		chronos.start();
		Clerk clerk = TrackerFactory.createClerk(mailBox, config);
		clerk.start();
	}
}
