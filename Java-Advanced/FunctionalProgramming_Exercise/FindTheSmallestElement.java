package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Consumer<List<Integer>> printLastIndexOfMinElement = list -> {

            int minElement = Collections.min(list);
            System.out.println(list.lastIndexOf(minElement));
        };
        printLastIndexOfMinElement.accept(numbers);
    }
}
