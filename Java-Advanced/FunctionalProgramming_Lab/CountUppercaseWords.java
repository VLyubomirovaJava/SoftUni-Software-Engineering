package FunctionalProgramming_Lab;

import java.util.*;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] wordArray = scanner.nextLine().split("\\s+");
        Predicate<String> isFirstLetterCapital = word -> Character.isUpperCase(word.charAt(0));
        List<String> wordList = new ArrayList<>();
        Arrays.stream(wordArray)
                .filter(isFirstLetterCapital)
                .forEach(word -> wordList.add(word));
        System.out.println(wordList.size());
        wordList.forEach(System.out::println);
    }
}