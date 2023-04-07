package football.entities.supplement;

import java.util.*;

public abstract class BaseSupplement implements Supplement {
  private int energy;
  private double price;

    public BaseSupplement(int energy, double price) {
        setEnergy(energy);
        setPrice(price);
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
