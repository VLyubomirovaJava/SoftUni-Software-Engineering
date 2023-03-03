package workingWithAbstraction.CardsWithPower;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
CardRank cardRank = CardRank.parse(scanner.nextLine());
CardSuit cardSuit = CardSuit.parse(scanner.nextLine());
Card card = new Card(cardRank, cardSuit);
        System.out.printf("Card name: %s of %s; Card power: %d",cardRank.name(),cardSuit.name(),card.getCardPower());
        }

    }
