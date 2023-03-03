package workingWithAbstraction.CardSuit;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Card Suits: ");
        for (CardSuit cardType : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardType.ordinal(), cardType.name());
        }
    }
}