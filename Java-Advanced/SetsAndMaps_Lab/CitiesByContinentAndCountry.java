package SetsAndMaps_Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> cccInfo = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            cccInfo.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> citiesByCountry = cccInfo.get(continent);
            citiesByCountry.putIfAbsent(country, new ArrayList<>());
            citiesByCountry.get(country).add(city);
        }
        cccInfo.forEach((key, value) -> {
            System.out.println(key + ":");
            value.entrySet()
                    .forEach(country -> {
                        String output = String.join(", ", country.getValue());
                        System.out.println(" " + country.getKey() + " -> " + output);
                    });
        });
    }
}
