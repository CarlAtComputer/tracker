package pt.caughtonnet.tracker.roadsim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pt.caughtonnet.tracker.roadsim.snapshooter.data.domain.Road;

public class RoadSimulationRoad {

	private Road data;
	private boolean inverted;
	private Serializable id;
	private RoadSimulationWay way;
	private List<RoadSimulationCar> cars;
	
	public RoadSimulationRoad() {
		cars = new ArrayList<RoadSimulationCar>();
	}

	public Road getData() {
		return data;
	}
	
	public void setData(Road data) {
		this.data = data;
	}

	public void setInverted(boolean inverted) {
		this.inverted = inverted;
	}
	
	public boolean isInverted() {
		return inverted;
	}
	
	public Serializable getId() {
		return id;
	}
	
	public void setId(Serializable id) {
		this.id = id;
	}

	public void setWay(RoadSimulationWay way) {
		this.way = way;
	}

	public void addCar(RoadSimulationCar car) {
		cars.add(car);
	}
	
	public List<RoadSimulationCar> getCars() {
		return cars;
	}

	public void removeCar(RoadSimulationCar car) {
		if (!cars.contains(car)) {
			System.out.println("THERE IS NO CAR");
		} else {
			cars.remove(car);
		}
	}

}
