package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = scanner.nextInt();
        Collections.reverse(numbers);
        Predicate<Integer> checkDivision = number -> number % n == 0;
        numbers.removeIf(checkDivision); // to remove the number that are ''true'' under the predicate check
        numbers.forEach(number -> System.out.print(number + " "));


    }
}