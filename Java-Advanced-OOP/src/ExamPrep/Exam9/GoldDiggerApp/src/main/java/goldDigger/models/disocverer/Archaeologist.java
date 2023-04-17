package goldDigger.models.disocverer;

public class Archaeologist extends BaseDiscoverer {
    private final static double ENERGY_ARCHAEOLOGIST = 60;


    public Archaeologist(String name) {
        super(name, ENERGY_ARCHAEOLOGIST);
    }
}
