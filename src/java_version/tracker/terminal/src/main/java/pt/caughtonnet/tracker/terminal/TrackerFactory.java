/**
 * 
 */
package pt.caughtonnet.tracker.terminal;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;

import pt.caughtonnet.tracker.api.chronos.Chronos;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;
import pt.caughtonnet.tracker.config.TrackerConfiguration;

/**
 * @author CaughtOnNet
 */
public class TrackerFactory {

	/**
	 * @param config
	 * @return
	 */
	public static Chronos createChronos(TrackerConfiguration config) throws Exception {
		Class<?> snapshooterClazz = Class.forName(config.getSnapShooter().getInstance());
		Snapshooter snapshooter =  (Snapshooter) snapshooterClazz.newInstance();
		
		Class<?> chonosClazz = Class.forName(config.getChronos().getInstance());
		Chronos chronos = (Chronos) chonosClazz.newInstance();
		chronos.setChronosSnapshooter(snapshooter);
		chronos.setup(createConfiguration(config, chronos.getConfigurationBean()));
		
		return chronos;
	}

	/**
	 * @param config
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private static Object createConfiguration(TrackerConfiguration config, Class<?> clazz) throws Exception {
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		Map<String, Object> params = config.getChronos().getParameters();
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
