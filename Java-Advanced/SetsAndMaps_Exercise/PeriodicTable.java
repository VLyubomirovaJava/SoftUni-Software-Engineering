package SetsAndMaps_Exercise;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<String> chemicalElements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] chemicals = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(chemicals));
        }
        chemicalElements.forEach(chem -> System.out.print(chem + " "));
    }
}