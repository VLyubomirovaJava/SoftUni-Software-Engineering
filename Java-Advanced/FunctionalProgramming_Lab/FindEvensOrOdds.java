package FunctionalProgramming_Lab;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int start = Integer.parseInt(command.split("\\s+")[0]);
        int end = Integer.parseInt(command.split("\\s+")[1]);
        String filter = scanner.nextLine();
        List<Integer> numbersList = new ArrayList<>();
        //rangeclosed returns sequential ordered stream with incr step of +1;
        IntStream.rangeClosed(start, end).forEach(n -> numbersList.add(n));
        Predicate<Integer> filterByType = getFilterByType(filter);

        numbersList.stream().filter(filterByType).forEach
                (n -> System.out.print(n + " "));
    }

    private static Predicate<Integer> getFilterByType(String filter) {
        switch (filter) {
            case "even":
                return n -> n % 2 == 0;
            case "odd":
                return n -> n % 2 != 0;
            default:
                throw new IllegalArgumentException("Unknown condition " + filter);

        }
    }
}
