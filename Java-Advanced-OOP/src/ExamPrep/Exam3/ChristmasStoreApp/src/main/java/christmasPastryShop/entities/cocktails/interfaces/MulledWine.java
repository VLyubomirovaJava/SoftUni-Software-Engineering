package christmasPastryShop.entities.cocktails.interfaces;

public class MulledWine extends BaseCocktail {
    private final static double PRICE_MULLEDWINE = 3.50;

    public MulledWine(String name, int size, String brand) {
        super(name, size, PRICE_MULLEDWINE, brand);

    }
}