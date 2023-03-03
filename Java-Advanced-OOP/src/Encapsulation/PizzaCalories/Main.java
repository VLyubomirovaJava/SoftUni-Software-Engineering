package Encapsulation.PizzaCalories;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pizzaInfo = scanner.nextLine();
        String pizzaName = pizzaInfo.split("\\s+")[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo.split("\\s+")[2]);
        Pizza pizza = null;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String doughInfo = scanner.nextLine();
        String flourType = doughInfo.split("\\s+")[1];
        String bakingTechnique = doughInfo.split("\\s+")[2];
        double doughWeight = Double.parseDouble(doughInfo.split("\\s+")[3]);

        try {
            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] toppingInfo = input.split("\\s+");
            String toppingType = toppingInfo[1];
            double toppingWeight = Double.parseDouble(toppingInfo[2]);
            try {
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
                numberOfToppings--;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            if (numberOfToppings > 0) {
                input = scanner.nextLine();
            } else {
                break;
            }
        }
        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
