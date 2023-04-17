package goldDigger.models.disocverer;

public class Anthropologist extends BaseDiscoverer {
    private final static double ENERGY_ANTHROPO = 40;

    public Anthropologist(String name) {
        super(name, ENERGY_ANTHROPO);
    }
}
