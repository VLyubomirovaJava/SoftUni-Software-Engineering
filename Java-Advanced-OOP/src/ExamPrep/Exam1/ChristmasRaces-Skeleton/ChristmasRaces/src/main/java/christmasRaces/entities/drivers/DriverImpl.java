package christmasRaces.entities.drivers;

import christmasRaces.entities.cars.Car;

import java.util.*;

import static christmasRaces.common.ExceptionMessages.*;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty() || name.trim().length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_INVALID));
        }
        this.car = car;
        setCanParticipate();
    }

    @Override
    public void winRace() {
numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }

    public void setCanParticipate() {
        this.canParticipate= car != null;
    }

}


