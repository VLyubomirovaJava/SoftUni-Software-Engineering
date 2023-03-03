package FunctionalProgramming_Lab;

import java.util.*;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(", ");
        Function<String, Integer> parseInt = Integer::parseInt;

        int sum = 0;
        Function<String, Integer> mapper = parseInt.andThen(Integer::intValue);
        for (String s : inputArray) {
            int i = mapper.apply(s);
            sum += i;
        }
        int count = inputArray.length;

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
    }
}