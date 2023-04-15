package restaurant.entities.drinks;

import java.util.*;

public class Fresh extends BaseBeverage {
    private static final double PRICE_FRESH = 3.5;

    public Fresh(String name, int counter, String brand) {
        super(name, counter, 3.5, brand);
    }
}