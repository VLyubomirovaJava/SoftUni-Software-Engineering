package zoo.entities.animals;


public class AquaticAnimal extends BaseAnimal {
    private final static double KG_AQUATIC_ANIMAL=2.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind,KG_AQUATIC_ANIMAL, price);
    }

    @Override
    public void eat() {
setKg(KG_AQUATIC_ANIMAL+7.5);
    }
}
