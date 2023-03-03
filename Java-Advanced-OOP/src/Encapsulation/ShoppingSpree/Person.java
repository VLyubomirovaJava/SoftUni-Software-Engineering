package Encapsulation.ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }

    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }

    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            products.add(product);
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.name).append(" - ");
            sb.append(products.stream().map(Product::getName).collect(Collectors.joining(" , ")));
            return sb.toString();

        }
    }
}


