public class Place {
    private String name;
    private String type;
    private double latitude;
    private double longitude;
    private double estimatedCost;

    public Place(String name, String type, double latitude, double longitude, double estimatedCost) {
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.estimatedCost = estimatedCost;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") $" + estimatedCost;
    }
}
