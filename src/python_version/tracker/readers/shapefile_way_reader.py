
from api.coalescer.way_coalescer import WayReader 
from api.coalescer.way_coalescer import DataSource 
import ogr

class ShapefileWayReader(WayReader):
    def read_ways(self):
        for feature in self.source:
            print(feature.GetField(1))
        
class ShapefileDataSource(DataSource):
    def connect(self):
        ogr.RegisterAll()
        self.data_source = ogr.Open(self.params.location)
        self.data = self.data_source.GetLayer(self.params.layer)
        