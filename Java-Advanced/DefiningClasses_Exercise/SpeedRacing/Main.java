package DefiningClasses_Exercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();

        while (countOfCars-- > 0) {

            String[] carParts = scanner.nextLine().split("\\s+");
            //"{Model} {FuelAmount} {FuelCostFor1km}"
            String model = carParts[0];
            Double fuelAmount = Double.parseDouble(carParts[1]);
            Double fuelCostPer1km = Double.parseDouble(carParts[2]);
            Car car = new Car(model, fuelAmount, fuelCostPer1km);
            carMap.put(model, car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("\\s+");
            String carModelToDrive = commandParts[1];
            int kmToDrive = Integer.parseInt(commandParts[2]);
            // car from map
            Car carToDrive = carMap.get(carModelToDrive);
            if (!carToDrive.drive(kmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();

        }
        for (Car car : carMap.values()) {
            System.out.println(car.toString());
        }

    }
}
