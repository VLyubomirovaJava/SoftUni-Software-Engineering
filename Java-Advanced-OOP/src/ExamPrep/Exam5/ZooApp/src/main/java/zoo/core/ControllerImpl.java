package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.*;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
 private FoodRepository foodRepository;
 private Map<String,Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.put(areaName, area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Vegetable")){
            food =new Vegetable();
        } else if (foodType.equals("Meat")) {
            food =new Meat();
        } else{
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        this.foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE,foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food f = foodRepository.findByType(foodType);
        if (f==null){
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND,foodType));
        }
        areas.get(areaName).addFood(f);
        foodRepository.remove(f);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA,foodType,areaName);
    }


    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        String output;
        if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        String areaType = areas.get(areaName).getClass().getSimpleName();
        if (isValidArea(animal, areaType)) {
            areas.get(areaName).addAnimal(animal);
            return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else {
            output = AREA_NOT_SUITABLE;
        }
        return output;
    }

    @Override
    public String feedAnimal(String areaName) {
        this.areas.get(areaName).feed();
        return String.format("Animals fed: %d", ((Area)this.areas.get(areaName)).getAnimals().size());
    }

    public String calculateKg(String areaName) {
        double sum = this.areas.get(areaName).getAnimals().stream().mapToDouble(Animal::getKg).sum();
        return String.format("The kilograms of Area %s is %.2f.", areaName, sum);
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();

        for (Area a : this.areas.values()) {
            output.append(a.getInfo()).append(System.lineSeparator());
        }

        return output.toString().trim();
    }



    private boolean isValidArea(Animal animal, String areaType) {
        return ((animal.getClass().getSimpleName().equals("AquanticAnimal") && areaType.equals(("WaterArea")) ||
                (animal.getClass().getSimpleName().equals("TerrestrialAnimal")&& areaType.equals("LandArea"))));
    }
    }
