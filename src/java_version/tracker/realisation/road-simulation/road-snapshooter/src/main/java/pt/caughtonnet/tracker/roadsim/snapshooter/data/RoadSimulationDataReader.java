package pt.caughtonnet.tracker.roadsim.snapshooter.data;

import java.util.List;

import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.roadsim.snapshooter.data.domain.Road;

public interface RoadSimulationDataReader {
	public List<Road> readRoads(Integer maxRoadAmount) throws SnapshooterException;
}
