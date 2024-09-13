package demos.advanced.junit;

import java.util.LinkedList;
import java.util.List;

public class Polygon {
    List<Coordinate> coordinates;

    public void addCoordinate(Coordinate coordinate) {
        if (coordinates == null) {
            coordinates = new LinkedList<>();
        }
        this.coordinates.add(coordinate);
    }

    public double getLength() {
        if (coordinates == null) return 0;
        else {
            double distance = 0;
            //calculate distance
            return distance;
        }
    }
}
