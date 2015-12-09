class WayCoalescer:
    def __init__(self, params=None):
        self.params = params
        
    def coalesce(self, ways):
        raise NotImplementedError
    
class WayReader:
    def __init__(self, source):
        self.source = source
        self.source.connect()
    
    def read_ways(self):
        raise NotImplementedError

'''
DataSource DataSource
'''
class DataSource:
    def __init__(self, params):
        self.params = params
        self.data = None
        
    def connect(self):
        raise NotImplementedError
    
    def __iter__(self):
        return self.data   