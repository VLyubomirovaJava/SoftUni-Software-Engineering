package SetsAndMaps_Exercise;

import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueUsernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            uniqueUsernames.add(input);
        }
        for (String name : uniqueUsernames) {
            System.out.println(name);
        }

    }
}
