package restaurant;

import java.math.BigDecimal;
import java.util.*;

public class Food extends Product {

private double grams;
    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams=grams;
    }

    public double getGrams() {
        return grams;
    }
}
