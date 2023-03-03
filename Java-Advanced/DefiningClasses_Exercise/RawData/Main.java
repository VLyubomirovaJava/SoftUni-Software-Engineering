package DefiningClasses_Exercise.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countOfCars = Integer.parseInt(scanner.nextLine());
        HashMap<String, List<Car>> carsByCargoType = new HashMap<>();

        while (countOfCars-- > 0) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String model = commandParts[0];
            int engineSpeed = Integer.parseInt(commandParts[1]);
            int enginePower = Integer.parseInt(commandParts[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(commandParts[3]);
            String cargoType = commandParts[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tireList = new ArrayList<>();
            for (int tireItems = 5; tireItems <= 12; tireItems += 2) {
                Tire currentTire = new Tire(Double.parseDouble(commandParts[tireItems]), Integer.parseInt(commandParts[tireItems + 1]));
                tireList.add(currentTire);
            }
            Car currentCar = new Car(model, engine, cargo, tireList);
            // creating list  based off the type of cargo - fragile, non-fragile
            carsByCargoType.putIfAbsent(cargoType, new ArrayList<>());
            carsByCargoType.get(cargoType).add(currentCar);
        }
        String cargoInput = scanner.nextLine();
        carsByCargoType.get(cargoInput).forEach(car -> car.extract(cargoInput));
    }
}