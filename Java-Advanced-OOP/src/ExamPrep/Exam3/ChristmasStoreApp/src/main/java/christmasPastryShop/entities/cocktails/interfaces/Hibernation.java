package christmasPastryShop.entities.cocktails.interfaces;

import java.util.*;

public class Hibernation extends BaseCocktail {
    private final static double PRICE_HIBERNATION = 4.50;

    public Hibernation(String name, int size, String brand) {
        super(name, size, PRICE_HIBERNATION, brand);
    }
}
