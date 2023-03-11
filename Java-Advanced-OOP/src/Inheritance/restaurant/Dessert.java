package Inheritance.restaurant;

import java.math.BigDecimal;
import java.util.*;

public class Dessert extends Food {
private double calories;

    public double getCalories() {
        return calories;
    }

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories=calories;

    }
}
