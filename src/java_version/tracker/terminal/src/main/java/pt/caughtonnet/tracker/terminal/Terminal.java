/**
 * 
 */
package pt.caughtonnet.tracker.terminal;

import org.apache.log4j.Logger;

import pt.caughtonnet.tracker.api.chronos.Chronos;
import pt.caughtonnet.tracker.api.clerk.Clerk;
import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;
import pt.caughtonnet.tracker.config.TrackerConfiguration;

/**
 * @author CaughtOnNet
 */
public class Terminal {
	final static Logger logger = Logger.getLogger(new Throwable().getStackTrace()[0].getClassName());
	
	public static void main(String[] args) throws Exception {
		logger.trace("Starting Tracker Terminal");
		
		logger.trace("Loading configurations");
		TrackerConfiguration config = TrackerConfiguration.load();
		logger.trace("Configurations loaded");

		logger.trace("Creating mail box");
		TrackerMailBox mailBox = TrackerFactory.createMailBox(config);
		logger.trace("Mail box created");
		
		logger.trace("Creating Chronos");
		Chronos chronos = TrackerFactory.createChronos(mailBox, config);
		logger.trace("Chronos created");
		
		logger.trace("Starting Chronos");
		chronos.start();
		logger.trace("Chronos started");
		
		logger.trace("Creating Clerk");
		Clerk clerk = TrackerFactory.createClerk(mailBox, config);
		logger.trace("Clerk created");
		
		logger.trace("Starting Clerk");
		clerk.start();
		logger.trace("Clerk started");
	}
}
