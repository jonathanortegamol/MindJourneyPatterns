import java.util.ArrayList;
import java.util.List;

public class MapBoxAPI implements RoutesService {
    private String API_KEY = "MAPBOX-456";

    @Override
    public Route generateRoute(String initialPoint, String lastPoint, float budget, int time, List<String> hobbies) {
        System.out.println("MapBoxAPI generating route...");
        List<Place> places = new ArrayList<>();
        places.add(new Place("MapBox Restaurant", "Restaurant", 0, 0, 8));
        places.add(new Place("MapBox Gallery", "Tourist Stop", 0, 0, 6));
        return new Route(initialPoint, lastPoint, places, 8.5, 0.4);
    }

    @Override
    public List<Place> getNearPlaces(String point, double radius) {
        System.out.println("MapBoxAPI getting nearby places...");
        List<Place> list = new ArrayList<>();
        list.add(new Place("MB Coffee", "Café", 0, 0, 5));
        return list;
    }

    @Override
    public boolean isServiceAvailable() {
        return true;
    }

    @Override
    public String getServiceName() {
        return "MapBox API";
    }
}
