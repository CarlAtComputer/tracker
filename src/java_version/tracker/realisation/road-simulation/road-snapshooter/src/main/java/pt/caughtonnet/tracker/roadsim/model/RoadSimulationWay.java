package pt.caughtonnet.tracker.roadsim.model;

import java.util.ArrayList;
import java.util.List;

public class RoadSimulationWay {
	private List<RoadSimulationCar> cars;
	
	public RoadSimulationWay() {
		cars = new ArrayList<RoadSimulationCar>();
	}

	public void putCar(RoadSimulationCar car) {
		cars.add(car);
	}

}
