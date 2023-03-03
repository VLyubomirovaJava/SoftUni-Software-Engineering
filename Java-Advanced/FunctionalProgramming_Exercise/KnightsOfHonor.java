package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Consumer<String> printInput = x -> System.out.println("Sir " + x);
        for (String name : input) {


            printInput.accept(name);

        }
    }
}