package SetsAndMaps_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class NumberGameVoina {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rounds = 50;

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
// till the rounds reach zero

        while (--rounds > 0) {
            // getting top card from each deck and removing it
            int firstNumber = firstDeck.iterator().next();
            firstDeck.remove(firstNumber);

            int secondNumber = secondDeck.iterator().next();
            secondDeck.remove(secondNumber);
// if Player 1's card is better, he keeps both in the end of his deck
            if (firstNumber > secondNumber) {
                firstDeck.add(firstNumber);
                firstDeck.add(secondNumber);
                // case if Player 2  has better hand:
            } else if (secondNumber > firstNumber) {
                secondDeck.add(firstNumber);
                secondDeck.add(secondNumber);
            }
            // game should end if anyone's deck is empty
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        if (firstDeck.size() < secondDeck.size()) {
            System.out.println("Second player win!");
        } else if (secondDeck.size() < firstDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}