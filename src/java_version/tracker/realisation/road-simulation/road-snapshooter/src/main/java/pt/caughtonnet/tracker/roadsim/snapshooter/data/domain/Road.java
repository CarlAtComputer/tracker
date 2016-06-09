package pt.caughtonnet.tracker.roadsim.snapshooter.data.domain;

import java.util.Map;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;

import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException.SnapshooterExceptionType;

public class Road {
	private static final double DISTANCE_TOLERANCE = 1e-10;
	private Geometry geometry;
	private Map<String, Object> attributes;
	
	public enum ConnectionType {
		NOT_CONNECTED,
		CONNECTED,
		INVERT_CONNECTED
	}
	
	public Geometry getGeometry() {
		return geometry;
	}
	
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public ConnectionType isConnectedTo(Road road) {
		Geometry roadGeometry = road.getGeometry();
		if (!(roadGeometry instanceof LineString)) {
			throw new SnapshooterException("The geometry of the comparison road is wrong, it should be LineString and it is " + roadGeometry.getGeometryType(), SnapshooterExceptionType.SETUP);
		}
		
		if (!(geometry instanceof LineString)) {
			throw new SnapshooterException("The geometry of the road is wrong", SnapshooterExceptionType.SETUP);
		}
		
		LineString roadLine = (LineString) roadGeometry;
		
		Coordinate startingPoint = roadLine.getCoordinates()[0];
		Coordinate endingPoint = roadLine.getCoordinates()[roadLine.getCoordinates().length - 1];
		
		LineString thisLine = (LineString) geometry;
		Coordinate thisEndingPoint = thisLine.getCoordinates()[thisLine.getCoordinates().length - 1];
		
		if (thisEndingPoint.distance(startingPoint) < DISTANCE_TOLERANCE) {
			return ConnectionType.CONNECTED;
		}
		
		if (thisEndingPoint.distance(endingPoint) < DISTANCE_TOLERANCE) {
			return ConnectionType.INVERT_CONNECTED;
		}
		
		return ConnectionType.NOT_CONNECTED;
		
	}
}

