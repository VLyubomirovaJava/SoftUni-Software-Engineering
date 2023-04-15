package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer {
    private final static double  ENERGY_ANIMAL = 100;

    public AnimalExplorer(String name) {
        super(name, ENERGY_ANIMAL);
    }
}
