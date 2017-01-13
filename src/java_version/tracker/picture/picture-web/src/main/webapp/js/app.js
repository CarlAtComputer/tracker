$(function() {
	var iconFeatures = [];

	var iconFeature = new ol.Feature({
		geometry : new ol.geom.Point(ol.proj.transform([ -72.0704, 46.678 ], 'EPSG:4326', 'EPSG:3857')),
		name : 'Null Island',
		population : 4000,
		rainfall : 500
	});

	var iconFeature1 = new ol.Feature({
		geometry : new ol.geom.Point(ol.proj.transform([ -73.1234, 45.678 ], 'EPSG:4326', 'EPSG:3857')),
		name : 'Null Island Two',
		population : 4001,
		rainfall : 501
	});

	iconFeatures.push(iconFeature);
	iconFeatures.push(iconFeature1);

	var vectorSource = new ol.source.Vector({
		features : iconFeatures
	// add an array of features
	});

	
	
	var vectorLayer = new ol.layer.Vector({
		source : vectorSource,
		  style: function(feature, resolution) {
			  var iconStyle = new ol.style.Style({
				  image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
				    rotation: ((feature.getProperties().heading - 45) * 3.14) / 180,
				    src: 'img/plane.png'
				  }))
				});
			  return iconStyle;
		  }
	});

	var map = new ol.Map({
		target : 'map',
		layers : [ new ol.layer.Tile({
			source : new ol.source.OSM()
		}), vectorLayer ],
		view : new ol.View({
			center : ol.proj.fromLonLat([ 37.41, 8.82 ]),
			zoom : 4
		})
	});

	function fetchPositions() {
		var coords = (map.getView().calculateExtent(map.getSize()));
		var lowerLeft = ol.proj.toLonLat([coords[0], coords[1]]);
		var upperRight = ol.proj.toLonLat([coords[2], coords[3]]);
		$.get("positions?lowerLeft="+lowerLeft+"&upperRight="+upperRight, function(data) {
			vectorSource.clear();
			iconFeatures = [];
			for (i = 0; i < data.length; ++i) {
				iconFeature = new ol.Feature({
					geometry: new ol.geom.Point(ol.proj.fromLonLat([data[i].longitude, data[i].latitude])),
				});
				iconFeature.setProperties(data[i]);
				iconFeatures.push(iconFeature);
			}
			vectorSource.addFeatures(iconFeatures);
		});
	}

	fetchPositions();
	setInterval(fetchPositions, 1000);
});