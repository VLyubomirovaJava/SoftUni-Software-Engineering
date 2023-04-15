package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class DriverRepository implements Repository<Driver> {
    private Collection<Driver> models ;

    public DriverRepository() {
        this.models=new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        return models.stream().filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Driver model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Driver driver) {
        return models.remove(driver);
    }


}

