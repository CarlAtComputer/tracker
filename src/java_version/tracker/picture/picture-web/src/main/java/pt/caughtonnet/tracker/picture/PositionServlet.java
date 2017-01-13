package pt.caughtonnet.tracker.picture;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pt.caughtonnet.tracker.api.model.Track;
import pt.caughtonnet.tracker.flightradar.snapshooter.scrap.FlightRadarScrapper;
import pt.caughtonnet.tracker.flightradar.snapshooter.scrap.FlightRadarSnapshot;
import pt.caughtonnet.tracker.picture.common.Position;

@WebServlet(value="/positions")
public class PositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1899481731776376654L;
	private FlightRadarScrapper scrapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		scrapper = new FlightRadarScrapper();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("flight-radar.properties");
		scrapper.config(input);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Track> positions = new ArrayList<Track>();

		String[] llValues = req.getParameter("lowerLeft").split(",");
		double llLongitude = Double.parseDouble(llValues[0]);
		double llLatitude = Double.parseDouble(llValues[1]);
		
		String[] urValues = req.getParameter("upperRight").split(",");
		double urLongitude = Double.parseDouble(urValues[0]);
		double urLatitude = Double.parseDouble(urValues[1]);
		
		FlightRadarSnapshot shot = scrapper.scrap();
		scrapper.setBounds(urLatitude + "," + llLatitude + "," + llLongitude + ","+urLongitude);
		
		for (Track track: shot.getTracks()) {
			positions.add(track);
		}
		String json = new Gson().toJson(positions);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
	}
}
