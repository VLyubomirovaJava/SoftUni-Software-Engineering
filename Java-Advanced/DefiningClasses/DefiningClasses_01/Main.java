package DefiningClasses.DefiningClasses_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        while (n-- > 0) {
            String[] carDetails = scanner.nextLine().split(" ");
            Car car = (carDetails.length == 1)
                    ? new Car(carDetails[0])
                    : new Car(carDetails[0], carDetails[1], Integer.parseInt(carDetails[2]));
            carList.add(car);
        }
        carList.forEach(e -> System.out.println(e.toString()));


    }
}