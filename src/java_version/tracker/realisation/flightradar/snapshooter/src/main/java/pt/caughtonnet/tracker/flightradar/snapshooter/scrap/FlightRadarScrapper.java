package pt.caughtonnet.tracker.flightradar.snapshooter.scrap;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Properties;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author CaughtOnNet
 *
 */
public class FlightRadarScrapper {

	public static final String URL_PROPERTY = "url";
	public static final String BOUNDS_PROPERTY = "bounds";
	private String url;
	private String bounds;
	private FlightRadarParameterParser parser;

	public boolean config() {
		Properties props = new Properties();
		try (InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("flight-radar.properties")) {
			props.load(is);

			this.url = (String) props.get(URL_PROPERTY);
			this.bounds = (String) props.get(BOUNDS_PROPERTY);

		} catch (IOException e) {
			return false;
		}
		
		parser = new FlightRadarParameterParser();
		
		return true;
	}

	public FlightRadarSnapshot scrap() {
		ObjectMapper mapper = new ObjectMapper();
		URL url;
		System.setProperty("http.agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36");

		try {
			url = new URL(composeUrl());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			return null;
		}

		try (InputStream is = url.openStream()) {
			HashMap<String, Object> map = mapper.readValue(is, HashMap.class);
			return parser.parse(map);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Gets the url
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url
	 * 
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the bounds
	 * 
	 * @return the bounds
	 */
	public String getBounds() {
		return bounds;
	}

	/**
	 * Sets the bounds
	 * 
	 * @param bounds the bounds to set
	 */
	public void setBounds(String bounds) {
		this.bounds = bounds;
	}

	/**
	 * @return The complete url
	 */
	public String composeUrl() {
		MessageFormat format = new MessageFormat(this.url);
		return format.format(new Object[] { this.bounds });
	}
}
