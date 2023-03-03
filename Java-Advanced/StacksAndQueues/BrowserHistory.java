package StacksAndQueues;

import java.util.*;

public class BrowserHistory {
    public static void main(String[] args) {
// 1. receive input from user -> print the URL
        // if input = "back" -> reverse to previous URL,
        //  if no previous URL  -> print no previous URL
        // if input = "Home" -> stop the program
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String currentUrl = null;
        ArrayDeque<String> history = new ArrayDeque<>();
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = history.pop();
                }
            } else {
                if (currentUrl != null) {
                    history.push(currentUrl);
                }
                currentUrl = input;
            }


            System.out.println(currentUrl);
            input = scanner.nextLine();
        }
    }
}


