package pt.caughtonnet.tracker.api.exception.chronos;

/**
 * Chronos Exception
 * @author CaughtOnNet
 */
public class ChronosException extends Exception {

	/**
	 * Serial number
	 */
	private static final long serialVersionUID = 8783353627080388158L;
	
	/**
	 * Default contructor
	 * @param message The exception message
	 * @param E Exception
	 */
	public ChronosException(String message, Exception exception) {
		super(message, exception);
	}
	
	

}
