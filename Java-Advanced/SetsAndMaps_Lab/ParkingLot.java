package SetsAndMaps_Lab;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashSet<String> parking = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String[] commandData = input.split(", ");
            String carNumber = commandData[1];
            String direction = commandData[0];
            if (direction.equals("IN")) {
                parking.add(carNumber);
            } else {
                parking.remove(carNumber);
            }

            input = scanner.nextLine();

        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            printSet(parking);
        }


    }


    private static void printSet(LinkedHashSet<String> parking) {
        for (String licensePlate : parking) {
            System.out.println(licensePlate);
        }

    }
}
