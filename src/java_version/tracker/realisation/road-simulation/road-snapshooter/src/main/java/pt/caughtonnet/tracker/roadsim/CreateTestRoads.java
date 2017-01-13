package pt.caughtonnet.tracker.roadsim;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geotools.data.DataStore;
import org.geotools.data.DefaultTransaction;
import org.geotools.data.Transaction;
import org.geotools.data.collection.ListFeatureCollection;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiPolygon;

public class CreateTestRoads {

	public static void main(String[] args) throws Exception {
		File shapefile = new File("/home/baia/Work/projects/tracker/produced/roads.shp");
		ShapefileDataStoreFactory f = new ShapefileDataStoreFactory();
		Map<String, Serializable> params = new HashMap<String, Serializable>();
		params.put(ShapefileDataStoreFactory.URLP.getName(), shapefile.toURI().toURL());
		params.put(ShapefileDataStoreFactory.CREATE_SPATIAL_INDEX.key, Boolean.TRUE);
		DataStore ds = f.createNewDataStore(params);
		
		SimpleFeatureTypeBuilder sftb = new SimpleFeatureTypeBuilder();
		sftb.setName(shapefile.toURI().toString());
		sftb.setCRS(DefaultGeographicCRS.WGS84);
		sftb.add("id", Long.class);
		sftb.add("name", String.class);
		sftb.add("the_geom", LineString.class);

		SimpleFeatureType sft = sftb.buildFeatureType();

		ShapefileDataStoreFactory sf = new ShapefileDataStoreFactory();
		ShapefileDataStore newDataStore = (ShapefileDataStore) sf.createNewDataStore(params);
		newDataStore.createSchema(sft);
		SimpleFeatureSource fss = (SimpleFeatureSource) newDataStore.getFeatureSource();
		LineString line;
		Coordinate[] coordinates;
		
		if (fss instanceof SimpleFeatureStore) {

			List<SimpleFeature> features = new ArrayList<SimpleFeature>();
			GeometryFactory gf = JTSFactoryFinder.getGeometryFactory();
			SimpleFeatureBuilder featureBuilder;
			Coordinate lastCoordinate = new Coordinate(0, 0);
			for (int i = 0; i < 10000; i++) {
				coordinates = new Coordinate[2];
				coordinates[0] = new Coordinate(lastCoordinate);
				coordinates[1] = new Coordinate(lastCoordinate.x + (Math.random() * 0.1 - 0.05), lastCoordinate.y + (Math.random() * 0.1 - 0.05));
				line = gf.createLineString(coordinates);
				featureBuilder = new SimpleFeatureBuilder(sft);
				featureBuilder.set("id", i);
				featureBuilder.set("the_geom", line);
				featureBuilder.set("name", "Road_" + i);
				
				lastCoordinate = coordinates[1];
				SimpleFeature feature = featureBuilder.buildFeature(null);
				features.add(feature);
			}
			SimpleFeatureCollection collection = new ListFeatureCollection(sft, features);

			SimpleFeatureStore fs = (SimpleFeatureStore) fss;
			Transaction t = new DefaultTransaction("create");
			fs.setTransaction(t);
			fs.addFeatures(collection);
			t.commit();
			t.close();
		}
		
		newDataStore.dispose();
		newDataStore = null;
	}

}
