package pt.caughtonnet.tracker.roadsim.snapshooter.data.shapefile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.geotools.data.FeatureReader;
import org.geotools.data.FileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryCollection;

import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException.SnapshooterExceptionType;
import pt.caughtonnet.tracker.roadsim.snapshooter.data.RoadSimulationDataReader;
import pt.caughtonnet.tracker.roadsim.snapshooter.data.domain.Road;

public class RoadSimulationShapefileReader implements RoadSimulationDataReader {
	final static Logger logger = LoggerFactory.getLogger(new Throwable().getStackTrace()[0].getClassName());

	private String shapefileLocation;

	public RoadSimulationShapefileReader(String shapefileLocation) {
		this.shapefileLocation = shapefileLocation;
	}

	@Override
	public List<Road> readRoads(Integer maxRoadAmount) throws SnapshooterException {
		FeatureReader<SimpleFeatureType, SimpleFeature> featReader;
		List<Road> roads = new ArrayList<Road>();
		Map<String, Object> attributes;
		ShapefileDataStoreFactory f;
		SimpleFeatureType ft;
		SimpleFeature feat;
		FileDataStore ds;
		File shapefile;
		Geometry geom;
		String lName;
		Road road;

		logger.trace("Reading the shapefile " + shapefileLocation);
		
		shapefile = new File(this.shapefileLocation);
		if (!isValid()) {
			logger.error("Shapefile does not exist");
			throw new SnapshooterException("Shapefile does not exist", SnapshooterExceptionType.SETUP);
		}
		
		f = new ShapefileDataStoreFactory();
		
		try {
			ds = f.createDataStore(shapefile.toURI().toURL());
		} catch (IOException e) {
			logger.error("Error while opening the shapefile datasource", e);
			throw new SnapshooterException("Error while opening the shapefile datasource", SnapshooterExceptionType.SETUP, e);
		}
		
		try {
			featReader = ds.getFeatureReader();
		} catch (IOException e) {
			logger.error("Error while getting the features from datasource", e);
			throw new SnapshooterException("Error while getting the features from datasource", SnapshooterExceptionType.SETUP, e);
		}
		
		ft = featReader.getFeatureType();
			
		try {
			while (featReader.hasNext()) {
				if (roads.size() >= maxRoadAmount) {
					break;
				}
				feat = featReader.next();
				geom = (Geometry) feat.getAttribute(feat.getDefaultGeometryProperty().getName());
				attributes = new HashMap<String, Object>();
				for (int i=0; i < feat.getAttributeCount(); i++) {
					lName = ft.getDescriptor(i).getLocalName();
					if (!lName.equals(feat.getDefaultGeometryProperty().getName())) {
						attributes.put(lName, feat.getAttribute(i));		
					}
				}
				
				ArrayList<Geometry> geoms = new ArrayList<Geometry>();
				if (geom instanceof GeometryCollection) {
					GeometryCollection col = (GeometryCollection) geom;
					for (int i = 0; i < col.getNumGeometries(); i++) {
						geoms.add(col.getGeometryN(i));
					}
				} else {
					geoms.add(geom);
				}
				
				for (Geometry decGeom : geoms) {
					road = new Road();
					road.setGeometry(decGeom);
					road.setAttributes(attributes);
					roads.add(road);
				}
			}
		} catch (IllegalArgumentException | NoSuchElementException | IndexOutOfBoundsException | IOException e) {
			logger.error("Error while working with the features from datasource", e);
			throw new SnapshooterException("Error while getting the features from datasource", SnapshooterExceptionType.SETUP, e);
		}
		
		return roads;
	}

	public boolean isValid() {
		return shapefileExists();
	}

	private boolean shapefileExists() {
		File shapefile = new File(this.shapefileLocation);
		return shapefile.exists();
	}
	
	

}
