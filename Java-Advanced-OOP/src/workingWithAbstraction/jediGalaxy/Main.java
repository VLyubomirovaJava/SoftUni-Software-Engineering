package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Field field = new Field(readDimensions(input));
        input = scanner.nextLine();
        long points = 0;

        while (!input.equals("Let the Force be with you")) {
            Player peter = new Player(readDimensions(input));
            input = scanner.nextLine();
            EvilForce evil = new EvilForce(readDimensions(input));
            Galaxy galaxy = new Galaxy(field, evil, peter);
            galaxy.moveEvil();
            galaxy.movePlayer();
            points += peter.getPoints();
            input = scanner.nextLine();
        }

        System.out.println(points);


    }

    // getting the rows and columns from the input
    private static int[] readDimensions(String command) {
        return Arrays.stream(command.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
