import java.util.ArrayList;
import java.util.List;

public class GoogleMapsAPI implements RoutesService {
    private String API_KEY = "GOOGLE-123";

    @Override
    public Route generateRoute(String initialPoint, String lastPoint, float budget, int time, List<String> hobbies) {
        System.out.println("GoogleMapsAPI generating route...");
        List<Place> places = new ArrayList<>();
        places.add(new Place("Google Café", "Restaurant", 0, 0, 10));
        places.add(new Place("Google Museum", "Tourist Stop", 0, 0, 5));
        return new Route(initialPoint, lastPoint, places, 10.0, 0.5);
    }

    @Override
    public List<Place> getNearPlaces(String point, double radius) {
        System.out.println("GoogleMapsAPI getting nearby places...");
        List<Place> list = new ArrayList<>();
        list.add(new Place("G-Lunch", "Restaurant", 0, 0, 12));
        return list;
    }

    @Override
    public boolean isServiceAvailable() {
        return true;
    }

    @Override
    public String getServiceName() {
        return "Google Maps API";
    }
}
