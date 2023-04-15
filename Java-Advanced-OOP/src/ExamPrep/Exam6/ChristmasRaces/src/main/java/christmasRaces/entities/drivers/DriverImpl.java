package christmasRaces.entities.drivers;

import christmasRaces.core.interfaces.cars.Car;

import static christmasRaces.common.ExceptionMessages.CAR_INVALID;
import static christmasRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.numberOfWins = 0;
        setCanParticipate();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;


    }

    @Override
    public Car getCar() {
        return car;
    }


    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }


    public void setCanParticipate() {
        this.canParticipate = car != null;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);

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
}



