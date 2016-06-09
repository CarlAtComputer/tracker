/**
 * 
 */
package pt.caughtonnet.tracker.api.exception.snapshooter;

/**
 * Snapshooter Exception
 * @author CaughtOnNet
 */
public class SnapshooterException extends RuntimeException {
	
	/**
	 * Serial serializable number
	 */
	private static final long serialVersionUID = -6894885298901951758L;

	/**
	 * @author CaughtOnNet
	 */
	public enum SnapshooterExceptionType {
		GENERAL_ERROR,
		SETUP,
		SHOOT
	}

	/**
	 * Snapshooter exception type
	 */
	private SnapshooterExceptionType type;

	/**
	 * Constructor
	 * @param e 
	 */
	public SnapshooterException(String message, SnapshooterExceptionType type, Throwable exception) {
		super(message, exception);
		this.type = type;
	}
	
	/**
	 * Constructor
	 * @param e 
	 */
	public SnapshooterException(String message, SnapshooterExceptionType type) {
		super(message);
		this.type = type;
	}

	/**
	 * Constructor
	 */
	public SnapshooterException(String message, Throwable exception) {
		super(message, exception);
		this.type = SnapshooterExceptionType.GENERAL_ERROR;
	}
	
	/**
	 * Gets the type
	 * @return the type
	 */
	public SnapshooterExceptionType getType() {
		return type;
	}

}
