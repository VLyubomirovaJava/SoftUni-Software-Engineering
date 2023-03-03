package SetsAndMaps_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .collect(Collectors.toList());
        for (int num : numbers
        ) {
            System.out.print(num + " ");
        }
    }
}