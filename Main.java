import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RoutesProxy proxy = new RoutesProxy();

        System.out.println("Active service: " + proxy.getServiceName());
        var route = proxy.generateRoute("Quito", "Cuenca", 45.90f, 5, Arrays.asList("comida", "arte"));
        System.out.println(route);

        System.out.println("\nSimulando cambio de servicio...");
        proxy.switchToNextService();
        var route2 = proxy.generateRoute("Cuenca", "Guayaquil", 65.54f, 3, Arrays.asList("playa", "fotografía"));
        System.out.println(route2);
    }
}
