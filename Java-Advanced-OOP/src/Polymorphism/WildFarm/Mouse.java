package WildFarm;

import WildFarm.Food;
import WildFarm.Vegetable;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
public     void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
   public void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            setFoodEaten(0 + getFoodEaten());
            System.out.printf("Mice are not eating that type of food!%n");
        }


    }

    @Override
    public String toString() {
        return super.toString();
    }
}