package goldDigger.models.disocverer;

public class Geologist extends BaseDiscoverer {
    private final static double ENERGY_GEOLOGIST = 100;


    public Geologist(String name) {
        super(name, ENERGY_GEOLOGIST);
    }
}

