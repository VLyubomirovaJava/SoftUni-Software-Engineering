package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Consumer<String> printInput = System.out::println;
        for (String name : input) {
            printInput.accept(name);
        }
    }
}