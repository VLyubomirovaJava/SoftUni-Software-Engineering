package FunctionalProgramming_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> onlyEvens = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(onlyEvens.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(onlyEvens.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
        );

    }


}
