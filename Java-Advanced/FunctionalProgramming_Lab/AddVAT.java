package FunctionalProgramming_Lab;

import java.util.*;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        UnaryOperator<Double> vat = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(prices).forEach(x -> System.out.printf("%.2f%n", vat.apply(x)));
    }
}