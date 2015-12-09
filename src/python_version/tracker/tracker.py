from readers.shapefile_way_reader import ShapefileWayReader, ShapefileDataSource

def main():
    source = type("source", (), {"type": "file", "location":"/home/baia/Work/geodata/2015-7-31-16-49-7-421__Cont_CAOP2015_hgDatum73/Cont_AAD_CAOP2015_hgdatum73.shp", "layer": 0})()
    print(source.type)
    print(source.location)
    reader = ShapefileWayReader(ShapefileDataSource(source))
    reader.read_ways()


if __name__ == "__main__": main()