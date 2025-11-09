import java.util.List;

public class Route {
    private String pointA;
    private String pointB;
    private List<Place> stops;
    private double distance;
    private double estimatedTime;

    public Route(String pointA, String pointB, List<Place> stops, double distance, double estimatedTime) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.stops = stops;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
    }

    @Override
    public String toString() {
        return "Route from " + pointA + " to " + pointB + " (" + distance + " km, " + estimatedTime + " hrs)\nStops: " + stops;
    }
}
