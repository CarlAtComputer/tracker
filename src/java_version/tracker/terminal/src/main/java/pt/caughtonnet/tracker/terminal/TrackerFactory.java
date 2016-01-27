/**
 * 
 */
package pt.caughtonnet.tracker.terminal;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import pt.caughtonnet.tracker.api.chronos.Chronos;
import pt.caughtonnet.tracker.api.clerk.Clerk;
import pt.caughtonnet.tracker.api.clerk.Courier;
import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;
import pt.caughtonnet.tracker.config.ParameterConfiguration;
import pt.caughtonnet.tracker.config.TrackerConfiguration;

/**
 * @author CaughtOnNet
 */
public class TrackerFactory {

	/**
	 * @param mailBox 
	 * @param config
	 * @return
	 */
	public static Chronos createChronos(TrackerMailBox mailBox, TrackerConfiguration config) throws Exception {
		Class<?> snapshooterClazz = Class.forName(config.getSnapShooter().getInstance());
		Snapshooter snapshooter =  (Snapshooter) snapshooterClazz.newInstance();
		Class<?> chonosClazz = Class.forName(config.getChronos().getInstance());
		Chronos chronos = (Chronos) chonosClazz.newInstance();
		chronos.setChronosSnapshooter(snapshooter);
		chronos.setMailBox(mailBox);
		chronos.setup(createConfiguration(config.getChronos(), chronos.getConfigurationBean()));
		return chronos;
	}

	/**
	 * @param mailBox 
	 * @param config
	 * @return
	 * @throws Exception 
	 */
	public static Clerk createClerk(TrackerMailBox mailBox, TrackerConfiguration config) throws Exception {
		Class<?> clerkClazz = Class.forName(config.getClerk().getInstance());
		Class<?> courierClazz = Class.forName(config.getClerk().getCourier().getInstance());
		Clerk clerk =  (Clerk) clerkClazz.newInstance();
		Courier courier =  (Courier) courierClazz.newInstance();
		clerk.setMailBox(mailBox);
		clerk.setCourier(courier);
		clerk.setup(createConfiguration(config.getClerk(), clerk.getConfigurationBean()));
		return clerk;
	}

	/**
	 * @param config
	 * @return
	 * @throws Exception 
	 */
	public static TrackerMailBox createMailBox(TrackerConfiguration config) throws Exception {
		Class<?> mailboxClazz = Class.forName(config.getMailbox().getInstance());
		TrackerMailBox mailbox = (TrackerMailBox) mailboxClazz.newInstance();
		mailbox.setup();
		return mailbox;
	}

	/**
	 * @param config
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private static Object createConfiguration(ParameterConfiguration config, Class<?> clazz) throws Exception {
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		Map<String, Object> params = config.getParameters();
		for (Field field : fields) {
			if (params.containsKey(field.getName())) {
				field.setAccessible(true);
				Object rawValue = params.get(field.getName());
				if (field.getType().isAssignableFrom(Date.class)) {
					field.set(obj, new SimpleDateFormat(TrackerConfiguration.DATE_FORMAT).parse(rawValue.toString()));
				} else {
					field.set(obj, field.getType().cast(rawValue));
				}
			}
		}
		return obj;
	}
	
}
