package zoo.entities.areas;


import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }
    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public int sumCalories() {
        int sumCalories = 0;
        for (Food food : foods) {
            sumCalories += food.getCalories();
        }
        return sumCalories;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.capacity == this.animals.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        } else {
            this.animals.add(animal);

        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        this.animals.stream().forEach(Animal::eat);

    }
     public   String getInfo(){
        StringBuilder sb = new StringBuilder();
         sb.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()));
         sb.append(System.lineSeparator());
         String animalsReport = this.animals.isEmpty() ? "None" : (String)this.animals.stream().map(Animal::getName).collect(Collectors.joining(" "));
         sb.append("Animals: ");
         sb.append(animalsReport).append(System.lineSeparator());
         sb.append("Foods: " + this.foods.size());
         sb.append(System.lineSeparator());
         sb.append("Calories: " + this.sumCalories());
         return sb.toString().trim();
     }
}


