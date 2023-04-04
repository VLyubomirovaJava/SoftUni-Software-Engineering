package christmasRaces.entities.cars;

import java.util.*;

import static christmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car {
private String model;
private int horsePower;
private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
       setModel(model);
        setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return model;
    }

    protected void setModel(String model) {
   if (model.equals(null) || model.trim().isEmpty() || model.trim().length()<4){
       throw new IllegalArgumentException(String.format(INVALID_MODEL, model,4));
   }
   this.model=model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / (horsePower * laps) ;
    }
}
