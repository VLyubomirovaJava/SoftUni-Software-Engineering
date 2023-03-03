package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
// get the int of command count
        // create stack
        // split command to create switch case for first part of command

        int countOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < countOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    stack.push(Integer.valueOf(command[1]));
                    break;

                case "2":
                    stack.pop();
                    break;

                case "3":
                    int maxNum = Collections.max(stack);
                    System.out.println(maxNum);
                    break;
            }
        }

    }
}