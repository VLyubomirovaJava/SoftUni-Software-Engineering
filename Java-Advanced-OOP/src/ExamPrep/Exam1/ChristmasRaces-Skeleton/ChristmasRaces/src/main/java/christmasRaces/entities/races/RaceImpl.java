package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.*;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {
private String name;
private int laps;
private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.name = name;
        this.laps = laps;
        this.drivers=new ArrayList<>();
    }

    public void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty() || name.trim().length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps<1){
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS,laps));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
if (driver==null){
    throw new IllegalArgumentException(DRIVER_INVALID);
}
if (!driver.getCanParticipate()){
    throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE,driver.getName()));
}
if (drivers.contains(driver)){
    throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED, driver.getName(),name));
}
drivers.add(driver);
    }

    public void setDrivers(Collection<Driver> drivers) {
        this.drivers = drivers;
    }
}
