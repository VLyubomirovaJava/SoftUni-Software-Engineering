package DefiningClasses.CarInfo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        while (n-- > 0) {
            String[] carParts = scanner.nextLine().split(" ");
            Car car = new Car();
            car.setBrand(carParts[0]);
            car.setModel(carParts[1]);
            car.setHorsepower(Integer.parseInt(carParts[2]));
            carList.add(car);
        }
        carList.stream().forEach(e -> System.out.println(e.toString()));
    }
}