package pt.caughtonnet.tracker.roadsim.model;

import java.io.Serializable;

public class RoadSimulationCar {
	private RoadSimulationRoad road;
	private double roadDriven;
	private double currentSpeed;
	private RoadSimulationCarCharacteristics characteristics;
	private Serializable id;
	
	public RoadSimulationCar(RoadSimulationCarCharacteristics characteristics) {
		this.characteristics = characteristics;
	}
	
	public RoadSimulationRoad getRoad() {
		return road;
	}
	
	public void setRoad(RoadSimulationRoad road) {
		roadDriven = 0.0d;
		this.road = road;
	}
	
	public double getRoadDriven() {
		return roadDriven;
	}
	
	public void setRoadDriven(double roadDriven) {
		this.roadDriven = roadDriven;
	}
	
	public double getCurrentSpeed() {
		return currentSpeed;
	}
	
	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	public RoadSimulationCarCharacteristics getCharacteristics() {
		return characteristics;
	}
	
	public static class RoadSimulationCarCharacteristics {
		private double maxSpeed;
		
		public RoadSimulationCarCharacteristics(double maxSpeed) {
			this.maxSpeed = maxSpeed;
		}
		
		public double getMaxSpeed() {
			return maxSpeed;
		}
	}
	
	public Serializable getId() {
		return id;
	}
	
	public void setId(Serializable id) {
		this.id = id;
	}
	
}
