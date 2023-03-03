package StacksAndQueues;

import java.util.*;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {

        // 1. receive input from user -> print the URL
        // if input = "back" -> reverse to previous URL,
        //  if no previous URL  -> print no previous URL
        // if input = "Home" -> stop the program
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> reverseHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (reverseHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.addFirst(reverseHistory.pop());
                    // adding at front of forward queue the first item from reverse queue
                    System.out.println(reverseHistory.peek());
                    // printing the first item in reverse queue, no removing
                }
            } else if (input.equals("forward")) {
                if (!forwardHistory.isEmpty()) {
                    System.out.println(forwardHistory.peek());
                    reverseHistory.push(forwardHistory.poll()); // makes first url of reverse Q the  head of forward + removes it
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                reverseHistory.push(input);
                forwardHistory.clear();
                System.out.println(input);
            }

            input = scanner.nextLine();


        }
    }

}
