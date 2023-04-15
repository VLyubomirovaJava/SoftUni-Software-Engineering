package restaurant.entities.healthyFoods;

import java.util.*;

public class VeganBiscuits extends Food {
    private final static double InitialSaladPortion_VEGAN = 205;

    public VeganBiscuits(String name, double price) {
        super(name, price, InitialSaladPortion_VEGAN);
    }
}
