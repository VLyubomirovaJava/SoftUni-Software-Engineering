package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private final static int KILOGRAMS_LONGHAIR = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 3);
    }

    @Override
    public int getKilograms() {
        return this.KILOGRAMS_LONGHAIR;
    }
}

