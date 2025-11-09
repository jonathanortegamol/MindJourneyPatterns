import java.util.*;

public class RoutesProxy implements RoutesService {
    private List<RoutesService> availableServices;
    private int activeIndex = 0;
    private Map<String, Object> cache = new HashMap<>();
    private Map<String, Integer> failureCount = new HashMap<>();
    private static final int MAX_RETRIES = 3;
    private static final int MAX_FAILURES = 2;

    public RoutesProxy() {
        availableServices = new ArrayList<>();
        availableServices.add(new GoogleMapsAPI());
        availableServices.add(new MapBoxAPI());
    }

    private RoutesService getActiveService() {
        return availableServices.get(activeIndex);
    }

    public void switchToNextService() {
        activeIndex = (activeIndex + 1) % availableServices.size();
        System.out.println("Switched to: " + getActiveService().getServiceName());
    }

    public boolean checkActiveServiceStatus() {
        return getActiveService().isServiceAvailable();
    }

    @Override
    public Route generateRoute(String initialPoint, String lastPoint, float budget, int time, List<String> hobbies) {
        String key = initialPoint + "-" + lastPoint;
        if (cache.containsKey(key)) {
            System.out.println("Returning cached route...");
            return (Route) cache.get(key);
        }

        for (int attempt = 0; attempt < MAX_RETRIES; attempt++) {
            try {
                if (!checkActiveServiceStatus()) {
                    throw new RuntimeException("Service unavailable");
                }
                Route route = getActiveService().generateRoute(initialPoint, lastPoint, budget, time, hobbies);
                cache.put(key, route);
                return route;
            } catch (Exception e) {
                log("Error with " + getServiceName() + ": " + e.getMessage());
                incrementFailure(getActiveService().getServiceName());
                switchToNextService();
            }
        }
        throw new RuntimeException("All services failed");
    }

    @Override
    public List<Place> getNearPlaces(String point, double radius) {
        return getActiveService().getNearPlaces(point, radius);
    }

    @Override
    public boolean isServiceAvailable() {
        return getActiveService().isServiceAvailable();
    }

    @Override
    public String getServiceName() {
        return getActiveService().getServiceName();
    }

    private void incrementFailure(String serviceName) {
        failureCount.put(serviceName, failureCount.getOrDefault(serviceName, 0) + 1);
        if (failureCount.get(serviceName) > MAX_FAILURES) {
            System.out.println(serviceName + " marked as unreliable");
        }
    }

    public void clearCache() {
        cache.clear();
    }

    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}
