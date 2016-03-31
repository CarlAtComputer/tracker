/**
 * 
 */
package pt.caughtonnet.tracker.flightradar.snapshooter.scrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pt.caughtonnet.tracker.api.model.Track;
import pt.caughtonnet.tracker.impl.model.DefaultTrack;

/**
 * @author CaughtOnNet
 *
 */
@SuppressWarnings("unchecked")
public class FlightRadarParameterParser {

	/**
	 * Full count parameter key
	 */
	private static final String FULL_COUNT_PARAM = "full_count";
	
	/**
	 * Version parameter key
	 */
	private static final String VERSION_PARAM = "version";
	
	/**
	 * Statistics parameter key
	 */
	private static final String STATS_PARAM = "stats";

	/**
	 * Plane attributes reg index
	 */
	private static final int PLANE_REGISTRATION_INDEX = 0;

	/**
	 * Plane attributes latitude index
	 */
	private static final int PLANE_LATITUDE_INDEX = 1;

	/**
	 * Plane attributes longitude index
	 */
	private static final int PLANE_LONGITUDE_INDEX = 2;

	/**
	 * Plane attributes heading index
	 */
	private static final int PLANE_HEADING_INDEX = 3;

	/**
	 * Plane attributes elevation index
	 */
	private static final int PLANE_ALTITUDE_INDEX = 4;

	/**
	 * Plane attributes speed index
	 */
	private static final int PLANE_SPEED_INDEX = 5;

	/**
	 * Plane attributes squawk index
	 */
	private static final int PLANE_SQUAWK_INDEX = 6;

	/**
	 * Plane attributes type index
	 */
	private static final int PLANE_TYPE_INDEX = 8;

	/**
	 * Plane attributes plane registration name index
	 */
	private static final int PLANE_REGISTRATION_NAME_INDEX = 9;

	/**
	 * Plane attributes origin airport acronym index
	 */
	private static final int PLANE_ORIGIN_AIRPORT_ACRONYM_INDEX = 11;

	/**
	 * Plane attributes destination airport acronym index
	 */
	private static final int PLANE_DESTINATION_AIRPORT_ACRONYM_INDEX = 12;

	/**
	 * Plane attributes flight number index
	 */
	private static final int PLANE_FLIGHT_NUMBER_INDEX = 13;

	/**
	 * Plane attributes callsign index
	 */
	private static final int PLANE_CALLSIGN_INDEX = 16;

	/**
	 * Plane reg parameter key
	 */
	private static final String PLANE_REGISTRATION_KEY = "Registration";

	/**
	 * Plane squawk parameter key
	 */
	private static final String PLANE_SQUAWK_KEY = "Squawk";

	/**
	 * Plane type parameter key
	 */
	private static final String PLANE_TYPE_KEY = "Type";
	
	/**
	 * @param map The Flight Radar Snapshot parameters map
	 * @return The snapshot
	 */
	public FlightRadarSnapshot parse(Map<String, Object> map) {
		FlightRadarSnapshot snapShot = new FlightRadarSnapshot();
		List<Track> tracks = new ArrayList<Track>();
		DefaultTrack track;
		Set<String> keys = map.keySet();
		
		String planeId, planeRegistration, planeSquawk, planeType, planeRegName, planeOriginAirportAcr, planeDestAirportAcr, planeFlightNumber, planeCallsign;
		Double planeLatitude, planeLongitude;
		Integer planeHeading, planeAltitude, planeSpeed;
		Map<String, Object> attributes;
		
		for (String key : keys) {
			if (
					!key.equals(FULL_COUNT_PARAM) &&
					!key.equals(VERSION_PARAM) &&
					!key.equals(STATS_PARAM)
				) {
				List<Object> planeMap = (List<Object>) map.get(key);
				
				planeId = key;
				planeAltitude = (Integer) planeMap.get(PLANE_ALTITUDE_INDEX);
				planeHeading = (Integer) planeMap.get(PLANE_HEADING_INDEX);
				planeLatitude = (Double) planeMap.get(PLANE_LATITUDE_INDEX);
				planeLongitude = (Double) planeMap.get(PLANE_LONGITUDE_INDEX);
				planeSpeed = (Integer) planeMap.get(PLANE_SPEED_INDEX);
				
				planeRegistration = (String) planeMap.get(PLANE_REGISTRATION_INDEX);
				planeSquawk = (String) planeMap.get(PLANE_SQUAWK_INDEX);
				planeType = (String) planeMap.get(PLANE_TYPE_INDEX);
				planeRegName = (String) planeMap.get(PLANE_REGISTRATION_NAME_INDEX);
				planeOriginAirportAcr = (String) planeMap.get(PLANE_ORIGIN_AIRPORT_ACRONYM_INDEX);
				planeDestAirportAcr = (String) planeMap.get(PLANE_DESTINATION_AIRPORT_ACRONYM_INDEX);
				planeFlightNumber = (String) planeMap.get(PLANE_FLIGHT_NUMBER_INDEX);
				planeCallsign = (String) planeMap.get(PLANE_CALLSIGN_INDEX);
				
				track = new DefaultTrack();
				track.setId(planeId);
				track.setAltitude(planeAltitude.doubleValue());
				track.setHeading(planeHeading.doubleValue());
				track.setLatitude(planeLatitude);
				track.setLongitude(planeLongitude);
				track.setSpeed(planeSpeed.doubleValue());
				attributes = new HashMap<String, Object>();
				attributes.put(PLANE_REGISTRATION_KEY, planeRegistration);
				attributes.put(PLANE_SQUAWK_KEY, planeSquawk);
				attributes.put(PLANE_TYPE_KEY, planeType);
				track.setAttributes(attributes);
				
				tracks.add(track);
			}
		}
		
		snapShot.setTracks(tracks);
		
		return snapShot;
	}

}
