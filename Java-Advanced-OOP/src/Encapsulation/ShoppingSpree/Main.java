package Encapsulation.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] personInfo = scanner.nextLine().split(";");
        Map<String, Person> shopperMap = new LinkedHashMap<>();
        for (String string : personInfo) {
            String name = string.split("=")[0];
            double money = Double.parseDouble(string.split("=")[1]);
            try {
                Person person = new Person(name, money);
                shopperMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Map<String, Product> productMap = new HashMap<>();
        String[] productInfo = scanner.nextLine().split(";");
        for (String object : productInfo) {
            String name = object.split("=")[0];
            double cost = Double.parseDouble(object.split("=")[1]);
            try {
                Product product = new Product(name, cost);
                productMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String order = scanner.nextLine();
        while (!order.equals("END")) {
            String customerName = order.split("\\s+")[0];
            String productName = order.split("\\s+")[1];
            if (shopperMap.containsKey(customerName) && productMap.containsKey(productName)) {
                Person currentPerson = shopperMap.get(customerName);
                Product currentProduct = productMap.get(productName);
                try {
                    currentPerson.buyProduct(currentProduct);
                    System.out.printf("%s bought %s%n", customerName, productName);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            order = scanner.nextLine();
        }
        shopperMap.values().forEach(System.out::println);


    }
}
