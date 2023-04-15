//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package restaurant.entities.tables;

import java.util.ArrayList;
import java.util.Collection;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood = new ArrayList();
    private Collection<Beverages> beverages = new ArrayList();
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.setPricePerPerson(pricePerPerson);
        this.isReservedTable = false;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    protected void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size has to be greater than 0!");
        } else {
            this.size = size;
        }
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException("Cannot place zero or less people!");
        } else {
            this.numberOfPeople = numberOfPeople;
        }
    }

    public int getTableNumber() {
        return this.number;
    }

    public int getSize() {
        return this.size;
    }

    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    public double allPeople() {
        this.allPeople = this.pricePerPerson * (double)this.numberOfPeople;
        return this.allPeople;
    }

    public void reserve(int numberOfPeople) {
        this.isReservedTable = true;
        this.setNumberOfPeople(numberOfPeople);
    }

    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    public double bill() {
        double priceForBeverages = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();
        double priceForFood = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        return this.allPeople() + (double)this.numberOfPeople * priceForBeverages + (double)this.numberOfPeople * priceForFood;
    }

    public void clear() {
        this.beverages.clear();
        this.healthyFood.clear();
        this.isReservedTable = false;
        this.allPeople = 0.0;
        this.numberOfPeople = 0;
    }

    public String tableInformation() {
        return String.format("Table - %d%nSize - %d%nType - %s%nAll price - %.2f", this.number, this.size, this.getClass().getSimpleName(), this.pricePerPerson);
    }
}
