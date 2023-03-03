package Exam18February;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] textilesData = scanner.nextLine().split("\\s+");
        Deque<Integer> textiles = new ArrayDeque<>();
        for (String textile : textilesData) {
            textiles.offer(Integer.parseInt(textile));
        }
        String[] medicamentsData = scanner.nextLine().split("\\s+");
        Deque<Integer> medicaments = new ArrayDeque<>();
        for (String medicament : medicamentsData) {
            medicaments.push(Integer.parseInt(medicament));
        }

        Map<String, Integer> healingItems = new TreeMap<>();

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            Integer textile = textiles.poll();
            Integer medicament = medicaments.pop();
            int possibleItem = medicament + textile;
            String healingItem = null;
            if (possibleItem == 30) {
                healingItem = "Patch";
            } else if (possibleItem == 40) {
                healingItem = "Bandage";

            } else if (possibleItem == 100) {
                healingItem = "MedKit";
            } else if (possibleItem > 100) {
                healingItem = "MedKit";
                int nextMed = medicaments.pop();
                medicaments.push(nextMed + (possibleItem - 100));
            } else {
                medicaments.push(medicament + 10);
            }
            if (healingItem != null) {
                healingItems.putIfAbsent(healingItem, 0);
                healingItems.put(healingItem, healingItems.get(healingItem) + 1);
            }
        }
        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");

        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");

        } else {
            System.out.println("Medicaments are empty.");

        }
        healingItems.entrySet().stream()
                .sorted((l, r) -> Integer.compare(r.getValue(), l.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        if (!textiles.isEmpty()) {
            System.out.println("Textiles left: " + textiles.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!medicaments.isEmpty()) {
            System.out.println("Medicaments left: " + medicaments.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }
    }
}