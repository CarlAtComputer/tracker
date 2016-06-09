package pt.caughtonnet.tracker.roadsim.snapshooter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineString;

import pt.caughtonnet.tracker.api.config.ConfigurableElement;
import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException.SnapshooterExceptionType;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.model.Track;
import pt.caughtonnet.tracker.impl.model.DefaultTrack;
import pt.caughtonnet.tracker.impl.snapshooter.DefaultSnapShooter;
import pt.caughtonnet.tracker.roadsim.model.RoadSimulationCar;
import pt.caughtonnet.tracker.roadsim.model.RoadSimulationCar.RoadSimulationCarCharacteristics;
import pt.caughtonnet.tracker.roadsim.model.RoadSimulationRoad;
import pt.caughtonnet.tracker.roadsim.model.RoadSimulationWay;
import pt.caughtonnet.tracker.roadsim.snapshooter.config.RoadSimulationSnapShooterConfiguration;
import pt.caughtonnet.tracker.roadsim.snapshooter.data.RoadSimulationDataReader;
import pt.caughtonnet.tracker.roadsim.snapshooter.data.domain.Road;
import pt.caughtonnet.tracker.roadsim.snapshooter.data.domain.Road.ConnectionType;
import pt.caughtonnet.tracker.roadsim.snapshooter.data.shapefile.RoadSimulationShapefileReader;
import pt.caughtonnet.tracker.roadsim.snapshooter.domain.RoadSimulationSnapShot;

public class RoadSimulationSnapShooter extends DefaultSnapShooter implements ConfigurableElement<RoadSimulationSnapShooterConfiguration> {
	final static Logger logger = LoggerFactory.getLogger(new Throwable().getStackTrace()[0].getClassName());

	private Integer maxCarAmount;
	private Integer maxRoadAmount;
	private Integer maxWayAmount;
	private String shapefileLocation;
	private RoadSimulationDataReader reader;
	
	private List<RoadSimulationWay> ways;

	@Override
	public Snapshot shoot(Date snapshotDate) throws SnapshooterException {
		RoadSimulationSnapShot shot = new RoadSimulationSnapShot();
		List<Track> currentTracks;
		currentTracks = new ArrayList<Track>();
		
		processSimulation(currentTracks);
		
		shot.setSnapDate(snapshotDate);
		shot.setTracks(currentTracks);
		return shot;
	}

	private void processSimulation(List<Track> tracksToFill) {
		DefaultTrack track;
		
		moveCars();
		
		for (RoadSimulationWay way : ways) {
			for (RoadSimulationRoad road : way) {
				List<RoadSimulationCar> cars = road.getCars();
				for (RoadSimulationCar car : cars) {
					track = new DefaultTrack();
					Coordinate carLocation = getCarLocationByDrivenPercentage(car, road);
					track.setLongitude(carLocation.x);
					track.setLatitude(carLocation.y);
					track.setId(car.getId());
					track.setSpeed(car.getCurrentSpeed());
					tracksToFill.add(track);
				}
			}
		}
		
	}

	private void moveCars() {
		for (RoadSimulationWay way : ways) {
			moveCars(way);
		}
	}

	private void moveCars(RoadSimulationWay way) {
		List<RoadSimulationCar> carsToRemove;
		
		carsToRemove = new ArrayList<RoadSimulationCar>();
		
		for (RoadSimulationRoad road : way) {
			List<RoadSimulationCar> cars = road.getCars();
			for (RoadSimulationCar car : cars) {
				if (car.getRoadDriven() >= 1.0d) {
					carsToRemove.add(car);
				} else {
					car.setRoadDriven(car.getRoadDriven() + calculatePercentageIncreaseByCar(road, car));
				}
			}
		}
		
		for (RoadSimulationCar carToRemove : carsToRemove) {
			if (!carToRemove.getRoad().getCars().remove(carToRemove)) {
				// TODO: Fazer isto melhor, quando acontece um erro então o chronos deve parar este snapshooter
				logger.error("There was an error on the car affection to roads, no car was found on road when it should be there");
				throw new SnapshooterException("There was an error on the car affection to roads, no car was found on road when it should be there", SnapshooterExceptionType.SHOOT);
			}
			RoadSimulationRoad newRoad = way.getNextRoad(carToRemove.getRoad());
			if (newRoad != null) {
				carToRemove.setRoad(newRoad);
				newRoad.addCar(carToRemove);
				carToRemove.setRoadDriven(0.0d);
			} else {
				way.putCarOnWay(carToRemove);
			}
		}

	}

	private double calculatePercentageIncreaseByCar(RoadSimulationRoad road, RoadSimulationCar car) {
		return 0.01;
	}

	@Override
	protected boolean setupSnapShooter() throws SnapshooterException {
		reader = new RoadSimulationShapefileReader(shapefileLocation);
		List<RoadSimulationCar> cars = createCars();
		List<RoadSimulationRoad> roads = createRoads();
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
			car = new RoadSimulationCar(new RoadSimulationCarCharacteristics(100.0d));
			car.setId(i);
			cars.add(car);
		}
		return cars;
	}
	
	private List<RoadSimulationRoad> createRoads() throws SnapshooterException {
		List<RoadSimulationRoad> simRoads = new ArrayList<RoadSimulationRoad>();
		
		try {
			List<Road> roads = reader.readRoads(maxRoadAmount);
			RoadSimulationRoad simRoad;
			for (int i = 0; i < roads.size(); i++) {
				simRoad = new RoadSimulationRoad();
				simRoad.setId(i);
				simRoad.setData(roads.get(i));
				simRoads.add(simRoad);
			}
		} catch (Exception e) {
			throw new SnapshooterException("Error while creating roads", e);
		}
		
		return simRoads;
	}

	private List<RoadSimulationWay> createWays(List<RoadSimulationRoad> roads) {
		RoadSimulationRoad randomConnectingRoad;
		List<RoadSimulationWay> ways;
		RoadSimulationWay way;
		ConnectionType connection;
		
		ways = new ArrayList<RoadSimulationWay>();
		
		// get a random road for start the way
		RoadSimulationRoad startingRoad = roads.get(Double.valueOf(Math.random() * roads.size()).intValue());
		
		// TODO: This will be on the configuration
		int maxRoadSize = 100;
		
		int waySize = 5 + Double.valueOf(Math.random() * maxRoadSize).intValue();
		way = new RoadSimulationWay();
		RoadSimulationRoad actualRoad = startingRoad;
		
		// find a connecting road
		while (way.size() < waySize) {
			// get the connecting roads
			randomConnectingRoad = null;
			for (RoadSimulationRoad road : roads) {
				// if it is the same continue
				if (road.getId().equals(actualRoad.getId())) continue;
				
				connection = road.getData().isConnectedTo(actualRoad.getData());
				
				if (connection.equals(ConnectionType.NOT_CONNECTED)) {
					continue;
				} else {
					//connection found
					randomConnectingRoad = road;
					if (connection.equals(ConnectionType.INVERT_CONNECTED)) {
						//invert connection
						randomConnectingRoad.setInverted(true);
					}
					break;
				}
			}
			
			if (randomConnectingRoad == null) {
				//there is no connections
				break;
			} else {
				way.add(randomConnectingRoad);
			}
			actualRoad = randomConnectingRoad;
		}
		
		for (RoadSimulationRoad road : way) {
			System.out.println(road.getData().getGeometry());
		}
		ways.add(way);
		return ways;
	}

	private void placeCarsOnWays(List<RoadSimulationCar> cars, List<RoadSimulationWay> ways) {
		Random rand = new Random();
		RoadSimulationWay way;
		for (RoadSimulationCar car : cars) {
			way = ways.get(rand.nextInt(ways.size()));
			way.putCarOnWay(car);
		}
	}

	private Coordinate getCarLocationByDrivenPercentage(RoadSimulationCar car, RoadSimulationRoad road) {
		LineString line = (LineString) road.getData().getGeometry();
		Coordinate[] coords = line.getCoordinates();
		int coordsSize = coords.length;
		Coordinate start, end;
		
		
		if (road.isInverted()) {
			start = coords[coordsSize - 1];
			end = coords[0];
		} else {
			start = coords[0];
			end = coords[coordsSize - 1];
		}
		
		double difX = end.x - start.x;
		double difY = end.y - start.y;
		
		
		return new Coordinate(start.x + (car.getRoadDriven() * difX), start.y + (car.getRoadDriven() * difY));
	}

}
