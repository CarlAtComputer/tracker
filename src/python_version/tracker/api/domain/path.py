from api.domain import Point

class Path:
    def __init__(self, x_init = -1, y_init = -1, x_final = -1, y_final = -1):
        self.initial = Point(x_init, y_init)
        self.final = Point(x_final, y_final)
        
    