/**
 * 
 */
package pt.caughtonnet.tracker.terminal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.caughtonnet.tracker.api.chronos.Chronos;
import pt.caughtonnet.tracker.api.clerk.Clerk;
import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;
import pt.caughtonnet.tracker.config.TrackerConfiguration;

/**
 * @author CaughtOnNet
 */
public class Terminal {
	final static Logger logger = LoggerFactory.getLogger(new Throwable().getStackTrace()[0].getClassName());
	
	public static void main(String[] args) throws Exception {
		if (logger.isTraceEnabled())
			logger.trace("Starting Tracker Terminal");
		
		if (logger.isTraceEnabled())
			logger.trace("Loading configurations");
		TrackerConfiguration config = TrackerConfiguration.load();
		if (logger.isTraceEnabled())
			logger.trace("Configurations loaded");

		if (logger.isTraceEnabled())
			logger.trace("Creating mail box");
		TrackerMailBox mailBox = TrackerFactory.createMailBox(config);
		if (logger.isTraceEnabled())
			logger.trace("Mail box created");
		
		if (logger.isTraceEnabled())
			logger.trace("Creating Chronos");
		Chronos chronos = TrackerFactory.createChronos(mailBox, config);
		if (logger.isTraceEnabled())
			logger.trace("Chronos created");
		
		if (logger.isTraceEnabled())
			logger.trace("Starting Chronos");
		chronos.start();
		if (logger.isTraceEnabled())
			logger.trace("Chronos started");
		
		if (logger.isTraceEnabled())
			logger.trace("Creating Clerk");
		Clerk clerk = TrackerFactory.createClerk(mailBox, config);
		if (logger.isTraceEnabled())
			logger.trace("Clerk created");
		
		if (logger.isTraceEnabled())
			logger.trace("Starting Clerk");
		clerk.start();
		if (logger.isTraceEnabled())
			logger.trace("Clerk started");
	}
}
