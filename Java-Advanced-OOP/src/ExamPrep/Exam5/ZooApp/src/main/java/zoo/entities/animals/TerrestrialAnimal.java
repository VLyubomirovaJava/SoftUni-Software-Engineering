package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    private final static double KG_TERRESTRIAL_ANIMAL=5.50;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind,KG_TERRESTRIAL_ANIMAL, price);
    }

    @Override
    public void eat() {
        setKg(KG_TERRESTRIAL_ANIMAL+5.7);
    }
}
