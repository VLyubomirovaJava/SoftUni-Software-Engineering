package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            Predicate<String> isValidCondition = getGuestList(command);
            String action = command.split("\\s+")[0];
            if (action.equals("Remove")) {
                List<String> toBeRemoved = guestList.stream().filter(isValidCondition)
                        .collect(Collectors.toList());
                guestList.removeAll(toBeRemoved);
            } else if (action.equals("Double")) {
                List<String> toBeAdded = guestList.stream().filter(isValidCondition).collect(Collectors.toList());
                guestList.addAll(toBeAdded);
            }
            command = scanner.nextLine();

        }
        if (guestList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guestList);
            for (int i = 0; i < guestList.size(); i++) {
                if (i < guestList.size() - 1) {
                    System.out.print(guestList.get(i) + ", ");
                } else {
                    System.out.print(guestList.get(i) + " are going to the party!");
                }
            }
        }
    }

    private static Predicate<String> getGuestList(String command) {
        String conditions = command.split("\\s+")[2];
        switch (command.split("\\s+")[1]) {
            case "StartsWith":
                return s -> s.startsWith(conditions);
            case "Length":
                return s -> s.length() == Integer.parseInt(conditions);
            case "EndsWith":
                return s -> s.endsWith(conditions);
            default:
                throw new IllegalArgumentException("Unknown condition " + command);
        }
    }
}

