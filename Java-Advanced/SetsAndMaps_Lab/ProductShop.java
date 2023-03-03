package SetsAndMaps_Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> storeInfo = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String store = input.split(", ")[0];
            String product = input.split(", ")[1];
            Double price = Double.parseDouble(input.split(", ")[2]);
            storeInfo.putIfAbsent(store, new LinkedHashMap<>());
            Map<String, Double> products = storeInfo.get(store);
            products.put(product, price);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : storeInfo.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (Map.Entry<String, Double> goods : entry.getValue().entrySet()) {
                String output = String.format("Product: %s, Price: %.1f", goods.getKey(), goods.getValue());
                System.out.println(output);
            }
        }
    }
}
