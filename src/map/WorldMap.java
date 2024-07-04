import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    private Map<String, String> locations;

    public WorldMap() {
        locations = new HashMap<>();
        locations.put("Town", "A small, peaceful town.");
        locations.put("Forest", "A dense forest filled with monsters.");
        locations.put("Castle", "The king's castle, where the final battle awaits.");
    }

    public Map<String, String> getLocations() {
        return locations;
    }

    public String getLocationDescription(String location) {
        return locations.get(location);
    }
}
