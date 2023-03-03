package SetsAndMaps_Exercise;

import java.util.*;

public class Phonebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            if (phonebook.containsKey(name)) {
                String currentNumber = phonebook.get(name);
                phonebook.replace(name, currentNumber, number);
            } else {
                phonebook.put(name, number);
            }
            input = scanner.nextLine();
        }
        String searchContact = scanner.nextLine();
        while (!searchContact.equals("stop")) {
            if (phonebook.containsKey(searchContact)) {
                System.out.println(searchContact + " -> " + phonebook.get(searchContact));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchContact);
            }
            searchContact = scanner.nextLine();
        }
    }
}