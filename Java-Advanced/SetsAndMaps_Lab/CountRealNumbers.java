package SetsAndMaps_Lab;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> realNumbersOcurrance = new LinkedHashMap<>();
        for (double value : values) {
            if (!realNumbersOcurrance.containsKey(value)) {
                realNumbersOcurrance.put(value, 1);
            } else {
                realNumbersOcurrance.put(value, realNumbersOcurrance.get(value) + 1);
            }
        }
        for (Double key : realNumbersOcurrance.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, realNumbersOcurrance.get(key)));
        }
    }
}