package SetsAndMaps_Lab;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> guests = new TreeSet<>();
        Set<String> vip = new TreeSet<>();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                guests.add(input);
            }
            input = scanner.nextLine();
        }

        while (!input.equals("END")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.remove(input);
            } else {
                guests.remove(input);
            }
            input = scanner.nextLine();
        }
        int totalCount = vip.size() + guests.size();
        System.out.println(totalCount);
        if (!vip.isEmpty()) {
            for (String vipGuest : vip) {
                System.out.println(vipGuest);
            }
        }
        if (!guests.isEmpty()) {
            for (String regular : guests) {
                System.out.println(regular);
            }
        }
    }
}
