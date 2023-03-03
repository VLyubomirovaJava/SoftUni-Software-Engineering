package workingWithAbstraction.CardRank;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Card Ranks:");
        for (cardRank rank : cardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.name());
        }
    }
}
