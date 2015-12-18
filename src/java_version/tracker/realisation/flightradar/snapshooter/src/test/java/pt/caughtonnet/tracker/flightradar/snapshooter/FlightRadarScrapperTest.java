package pt.caughtonnet.tracker.flightradar.snapshooter;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import pt.caughtonnet.tracker.flightradar.snapshooter.scrap.FlightRadarScrapper;

/**
 * @author CaughtOnNet
 *
 */
public class FlightRadarScrapperTest {
	
	private static final String CONFIG_FILE = "flight-radar.properties";
	
	@Test
	public void testConfig() throws Exception {
		FlightRadarScrapper scrapper = new FlightRadarScrapper();
		Assert.assertTrue("Scrapper configuration failed", scrapper.config());
		
		Properties props = new Properties();
		props.load(ClassLoader.getSystemClassLoader().getResourceAsStream(CONFIG_FILE));
		
		Assert.assertEquals(props.get(FlightRadarScrapper.URL_PROPERTY), scrapper.getUrl());
		Assert.assertEquals(props.get(FlightRadarScrapper.BOUNDS_PROPERTY), scrapper.getBounds());
	}
}
