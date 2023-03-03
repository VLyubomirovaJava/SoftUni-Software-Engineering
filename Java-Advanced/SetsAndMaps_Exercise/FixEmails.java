package SetsAndMaps_Exercise;

import java.util.*;

public class FixEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Map<String, String> emailData = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            // adding name + their email address
            String email = scanner.nextLine();
            emailData.put(name, email);
            name = scanner.nextLine();
        }
        emailData.entrySet().removeIf(entry ->
                entry.getValue().endsWith("us")
                        || entry.getValue().endsWith("uk")
                        || entry.getValue().endsWith("com"));
        emailData.forEach((entry, value) -> System.out.println(entry + " -> " + value));
    }
}
