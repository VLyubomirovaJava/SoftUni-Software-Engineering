package restaurant.entities.drinks;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.*;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseBeverage implements Beverages {
 private String name;
 private int counter;
 private double price;
 private String brand;

    public BaseBeverage(String name, int counter, double price, String brand) {
        this.setName(name);
        this.setCounter(counter);
        this.setPrice(price);
        this.setBrand(brand);
    }

    protected void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }



    protected void setCounter(int counter) {
        if (counter<=0){
            throw  new IllegalArgumentException(INVALID_COUNTER);
        }
        this.counter = counter;
    }

    public String getName() {
        return this.name;
    }

    public int getCounter() {
        return this.counter;
    }

    public double getPrice() {
        return this.price;
    }

    public String getBrand() {
        return this.brand;
    }

    protected void setPrice(double price) {
        if (price<=0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }


    protected void setBrand(String brand) {
        if (brand==null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }
}
