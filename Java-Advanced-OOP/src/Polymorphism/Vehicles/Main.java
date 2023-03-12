package Polymorphism.Vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        Vehicle car = createVehicle(tokens);
        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(tokens);
        Map<String, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put("Polymorphism.Vehicles.Car", car);
        vehicleMap.put("Polymorphism.Vehicles.Truck", truck);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];
            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    String message = vehicleMap.get(vehicleType).drive(distance);
                    System.out.println(message);
                    break;
                case "Refuel":
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    vehicleMap.get(vehicleType).refuel(fuelAmount);
                    break;
            }
        }
        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] tokens) {
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Polymorphism.Vehicles.Car":
                vehicle = new Car(fuelQuantity, fuelConsumption);
                break;
            case "Polymorphism.Vehicles.Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption);
                break;
        }
        return vehicle;
    }
}