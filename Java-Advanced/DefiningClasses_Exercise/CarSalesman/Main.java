package DefiningClasses_Exercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        while (countOfEngines-- > 0) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String modelEngine = engineData[0];
            int enginePower = Integer.parseInt(engineData[1]);
            int engineDisplacement = 0;
            String efficiency = null;
            //V4-33 140 28 B
            // to check if the optional engine details are there
            if (engineData.length == 4) {
                engineDisplacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                if (Character.isDigit(engineData[2].charAt(0))) {
                    engineDisplacement = Integer.parseInt(engineData[2]);
                } else {
                    efficiency = engineData[2];

                }
            }
            Engine engine = new Engine(modelEngine, enginePower, engineDisplacement, efficiency);
            engines.add(engine);
        }
        int countOfCars = Integer.parseInt(scanner.nextLine());
        while (countOfCars-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
//"{Model} {Engine} {Weight} {Color}
            String carModel = carData[0];
            String engineModel = carData[1];
            int weight = 0;
            String color = null;
            if (carData.length == 4) {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    weight = Integer.parseInt(carData[2]);
                } else {
                    color = carData[2];
                }
            }

            // looking for the engine from the ones we have on file
            // list of available ones -> for each cycle to find it
            Engine carEngine = null;
            for (Engine engine : engines) {
                if (engineModel.equals(engine.getModel())) {
                    carEngine = engine;
                    break;
                }
            }
            Car car = new Car(carModel, carEngine, weight, color);
            System.out.print(car.toString());

        }
    }
}
