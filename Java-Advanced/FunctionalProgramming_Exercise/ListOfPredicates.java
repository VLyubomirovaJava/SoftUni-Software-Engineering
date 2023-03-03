package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, list) -> {
            for (int numInList : list) {
                if (number % numInList != 0) {
                    return false;
                }
            }
            return true;
        });
        for (int number = 1; number <= n; number++) {
            if (isDivisible.apply(number, numbers)) {
                System.out.print(number + " ");
            }
        }
    }
}