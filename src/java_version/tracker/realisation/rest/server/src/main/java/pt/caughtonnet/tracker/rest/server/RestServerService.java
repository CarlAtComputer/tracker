package pt.caughtonnet.tracker.rest.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.caughtonnet.tracker.api.model.Track;
import pt.caughtonnet.tracker.impl.model.DefaultTrack;


@Controller
public class RestServerService {
	
	private static int count = 0;
	private int lastCount = 0;
	private Date lastTime;

	@RequestMapping(value="/track", method = RequestMethod.GET)
	public @ResponseBody List<Track> getAllTracks() {
		DefaultTrack track;
		List<Track> tracks = new ArrayList<Track>();
		for (int i = 0; i < 10; i++) {
			track = new DefaultTrack();
			track.setAltitude(1000.0 + i);
			track.setLatitude(1.0 + i);
			track.setLongitude(1.0 + i);
			tracks.add(track);
		}
		return tracks;
	}
	
	@RequestMapping(value="/track", method = RequestMethod.POST)
	public @ResponseBody int addTrack(@RequestBody DefaultTrack track) {
		count++;
		
		if (lastTime == null) {
			lastTime = new Date();
		}
		if (new Date().getTime() - lastTime.getTime() > 1000) {
			System.out.println(count - lastCount);
			lastTime = new Date();
			lastCount = count;
		}
		return count;
	}
}
