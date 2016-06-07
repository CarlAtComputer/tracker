package pt.caughtonnet.tracker.roadsim.snapshooter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import pt.caughtonnet.tracker.api.config.ConfigurableElement;
import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.impl.snapshooter.DefaultSnapShooter;
import pt.caughtonnet.tracker.roadsim.model.RoadSimulationCar;
import pt.caughtonnet.tracker.roadsim.model.RoadSimulationRoad;
import pt.caughtonnet.tracker.roadsim.model.RoadSimulationWay;
import pt.caughtonnet.tracker.roadsim.snapshooter.config.RoadSimulationSnapShooterConfiguration;

public class RoadSimulationSnapShooter extends DefaultSnapShooter implements ConfigurableElement<RoadSimulationSnapShooterConfiguration> {

	private Integer maxCarAmount;
	private Integer maxRoadAmount;
	private Integer maxWayAmount;
	private String shapefileLocation;
	
	private List<RoadSimulationCar> cars;
	private List<RoadSimulationRoad> roads;
	private List<RoadSimulationWay> ways;

	@Override
	public Snapshot shoot(Date snapshotDate) throws SnapshooterException {
		return null;
	}

	@Override
	protected boolean setupSnapShooter() {
		cars = createCars();
		roads = createRoads();
		ways = createWays(roads);
		placeCarsOnWays(cars, ways);
		return true;
	}

	@Override
	public Class<RoadSimulationSnapShooterConfiguration> getConfigurationBean() throws Exception {
		return RoadSimulationSnapShooterConfiguration.class;
	}

	@Override
	public void configure(RoadSimulationSnapShooterConfiguration config) throws Exception {
		this.shapefileLocation = config.getShapefileLocation();
		this.maxCarAmount = config.getMaxCarAmount();
		this.maxRoadAmount = config.getMaxRoadAmount();
		this.maxWayAmount = config.getMaxWayAmount();
	}

	private List<RoadSimulationCar> createCars() {
		List<RoadSimulationCar> cars = new ArrayList<RoadSimulationCar>();
		RoadSimulationCar car;
		for (int i = 0; i < maxCarAmount; i++) {
			car = new RoadSimulationCar();
			cars.add(car);
		}
		return cars;
	}
	
	private List<RoadSimulationRoad> createRoads() {
		readShapefile(this.shapefileLocation);
		List<RoadSimulationRoad> roads = new ArrayList<RoadSimulationRoad>();
		RoadSimulationRoad road;
		for (int i = 0; i < maxRoadAmount; i++) {
			road = new RoadSimulationRoad();
			roads.add(road);
		}
		return roads;
	}

	private void readShapefile(String shapefileLocation) {
		// TODO Auto-generated method stub
		System.out.println(shapefileLocation);
	}

	private List<RoadSimulationWay> createWays(List<RoadSimulationRoad> roads) {
		List<RoadSimulationWay> ways = new ArrayList<RoadSimulationWay>();
		RoadSimulationWay way;
		for (int i = 0; i < maxWayAmount; i++) {
			way = new RoadSimulationWay();
			ways.add(way);
		}
		return ways;
	}

	private void placeCarsOnWays(List<RoadSimulationCar> cars, List<RoadSimulationWay> ways) {
		Random rand = new Random();
		RoadSimulationWay way;
		for (RoadSimulationCar car : cars) {
			way = ways.get(rand.nextInt(ways.size()));
			way.putCar(car);
		}
	}

}
