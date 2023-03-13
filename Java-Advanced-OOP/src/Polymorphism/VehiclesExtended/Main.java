package Polymorphism.VehiclesExtended;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Polymorphism.VehiclesExtended.Car", createVehicle(scanner));
        vehicleMap.put("Polymorphism.VehiclesExtended.Truck", createVehicle(scanner));
        vehicleMap.put("Polymorphism.VehiclesExtended.Bus", createVehicle(scanner));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
          String[]  tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];
            double argument = Double.parseDouble(tokens[2]);

            switch (commandName) {
                case "DriveEmpty":
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
                    break;
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).driveWithAC(argument));
                    break;
                case "Refuel":
                    try{
                        vehicleMap.get(vehicleType).refuel(argument);
                    }catch (Exception exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
            }

        }
        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split(" ");
        String vehicleType = vehicleData[0];
        double fuelQuantity = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Polymorphism.VehiclesExtended.Car":
                vehicle = new Car(fuelQuantity, fuelConsumption,tankCapacity);
                break;
            case "Polymorphism.VehiclesExtended.Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption,tankCapacity);
                break;
            case "Polymorphism.VehiclesExtended.Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption,tankCapacity);
                break;
            default:
                throw new IllegalArgumentException("Missing car");

        }
        return vehicle;
    }
}