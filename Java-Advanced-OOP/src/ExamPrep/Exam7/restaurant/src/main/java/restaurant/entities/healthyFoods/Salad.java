package restaurant.entities.healthyFoods;

import java.util.*;

public class Salad extends Food {
  private final static double InitialSaladPortion = 150;

    public Salad(String name, double price) {
        super(name, price, InitialSaladPortion);
    }
}
