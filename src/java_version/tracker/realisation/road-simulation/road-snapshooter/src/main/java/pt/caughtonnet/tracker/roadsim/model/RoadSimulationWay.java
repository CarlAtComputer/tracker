package pt.caughtonnet.tracker.roadsim.model;

import java.util.ArrayList;
import java.util.Collection;

public class RoadSimulationWay extends ArrayList<RoadSimulationRoad> {
	private static final long serialVersionUID = 3360413810499058742L;
	
	public RoadSimulationWay() {
	}

	public void putCarOnWay(RoadSimulationCar car) {
		RoadSimulationRoad road = get(Double.valueOf(Math.random() * size()).intValue());
		road.addCar(car);
		car.setRoad(road);
	}
	
	@Override
	public void add(int index, RoadSimulationRoad road) {
		road.setWay(this);
		super.add(index, road);
	}
	
	@Override
	public boolean add(RoadSimulationRoad road) {
		road.setWay(this);
		super.add(0, road);
		return true;
	}
	
	@Override
	public boolean addAll(Collection<? extends RoadSimulationRoad> roads) {
		for (RoadSimulationRoad road : roads) {
			road.setWay(this);
		}
		return super.addAll(roads);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends RoadSimulationRoad> roads) {
		for (RoadSimulationRoad road : roads) {
			road.setWay(this);
		}
		return super.addAll(index, roads);
	}

	public RoadSimulationRoad getNextRoad(RoadSimulationRoad road) {
		int index = indexOf(road);
		if (index < size() - 1) {
			return get(index + 1);
		}
		return null;
	}

}
