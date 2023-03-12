package WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalName() {
        return animalName;
    }


    protected String getAnimalType() {
        return animalType;
    }

    protected Double getAnimalWeight() {
        return animalWeight;
    }
    protected Integer getFoodEaten() {
        return foodEaten;
    }

     void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

     abstract void makeSound();

     abstract void eat(Food food);

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, ", getAnimalType(), getAnimalName(), df.format(getAnimalWeight()));
    }
}


