import java.util.List;

public interface RoutesService {
    Route generateRoute(String initialPoint, String lastPoint, float budget, int time, List<String> hobbies);
    List<Place> getNearPlaces(String point, double radius);
    boolean isServiceAvailable();
    String getServiceName();
}
