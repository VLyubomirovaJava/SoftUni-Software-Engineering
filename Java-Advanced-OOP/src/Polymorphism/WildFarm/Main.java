package WildFarm;

import WildFarm.Animal;
import WildFarm.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> animalList = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();
        while (!input.equals("End")) {
            Animal animal = null;
            Food food;
            String[] animalData = input.split("\\s+");
            String[] foodData = scanner.nextLine().split("\\s+");
            String animalType = animalData[0];
            String animalName = animalData[1];
            Double animalWeight = Double.parseDouble(animalData[2]);
            String animalLivingRegion = animalData[3];
            switch (animalType) {
                case "WildFarm.Cat":
                    String breed = animalData[4];
                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
                    animalList.add(animal);
                    break;
                case "WildFarm.Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    animalList.add(animal);
                    break;
                case "WildFarm.Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    animalList.add(animal);
                    break;
                case "WildFarm.Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    animalList.add(animal);
                    break;
                default:
                    System.out.println("No such typeOfAnimal");
            }
            food = getFood(foodData);
            foodList.add(food);

            input = scanner.nextLine();
        }
        for (int i = 0; i < animalList.size(); i++) {
            animalList.get(i).makeSound();
            animalList.get(i).eat(foodList.get(i));
        }
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }

    private static Food getFood(String[] foodData) {
        Food food = null;
        String foodType = foodData[0];
        Integer foodQuantity = Integer.parseInt(foodData[1]);
        switch (foodType) {
            case "WildFarm.Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "WildFarm.Meat":
                food = new Meat(foodQuantity);
                break;
            default:
                System.out.println("No such type of WildFarm.Food");

        }
        return food;
    }
}