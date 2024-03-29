package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;

import java.util.ArrayList;
import java.util.Collection;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        this.drivers = new ArrayList<>();
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
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    public void setLaps(int laps) {
        if ( laps<1){
            throw  new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS,1));
        }
        this.laps = laps;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver==null){
            throw  new IllegalArgumentException(DRIVER_INVALID);
        }  if (!driver.getCanParticipate()){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE,driver.getName()));

        }  if (drivers.contains(driver)){
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS,driver.getName(),name));
        } else {
            drivers.add(driver);
        }
    }

}
