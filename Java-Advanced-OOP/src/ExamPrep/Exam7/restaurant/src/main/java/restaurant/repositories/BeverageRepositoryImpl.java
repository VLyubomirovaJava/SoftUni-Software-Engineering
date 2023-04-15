package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.*;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> entities;


    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.entities.stream()
                .filter(beverage ->beverage.getName().equals(drinkName) && beverage.getBrand().equals(drinkBrand))
        .findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(entities);
    }

    @Override
    public void add(Beverages entity) {
this.entities.add(entity);
    }
}
