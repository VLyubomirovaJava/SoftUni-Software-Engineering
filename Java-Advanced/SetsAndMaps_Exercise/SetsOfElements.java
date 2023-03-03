package SetsAndMaps_Exercise;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < first; i++) {
            firstSet.add(scanner.nextInt());
        }
        for (int i = 0; i < second; i++) {
            secondSet.add(scanner.nextInt());

        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(number -> System.out.print(number + " "));
    }
}
