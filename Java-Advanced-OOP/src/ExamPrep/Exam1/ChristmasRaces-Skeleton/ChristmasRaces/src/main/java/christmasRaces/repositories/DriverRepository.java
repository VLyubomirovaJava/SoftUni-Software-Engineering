package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class DriverRepository implements Repository<Driver> {
    private Collection<Driver> models;

    public DriverRepository() {
        this.models = new ArrayList<>();
    }
    @Override
    public Driver getByName(String name) {
        return models.stream().filter(d->d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Driver model) {
models.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return models.remove(model);
    }
}
