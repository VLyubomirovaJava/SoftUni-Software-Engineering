package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        Function<List<Integer>, List<Integer>> addCommand = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyCommand = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractCommand = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printCommand = list -> list.forEach(number -> System.out.print(number + " "));

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = addCommand.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyCommand.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractCommand.apply(numbers);
                    break;
                case "print":
                    printCommand.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }

    }
}
