package pt.caughtonnet.tracker.roadsim.snapshooter.config;

public class RoadSimulationSnapShooterConfiguration {

	private Integer maxCarAmount;
	private Integer maxRoadAmount;
	private Integer maxWayAmount;
	private String shapefileLocation;

	public Integer getMaxCarAmount() {
		return maxCarAmount;
	}

	public void setMaxCarAmount(Integer maxCarAmount) {
		this.maxCarAmount = maxCarAmount;
	}

	public Integer getMaxRoadAmount() {
		return maxRoadAmount;
	}

	public void setMaxRoadAmount(Integer maxRoadAmount) {
		this.maxRoadAmount = maxRoadAmount;
	}

	public Integer getMaxWayAmount() {
		return maxWayAmount;
	}

	public void setMaxWayAmount(Integer maxWayAmount) {
		this.maxWayAmount = maxWayAmount;
	}

	public String getShapefileLocation() {
		return shapefileLocation;
	}
	
	public void setShapefileLocation(String shapefileLocation) {
		this.shapefileLocation = shapefileLocation;
	}
}
