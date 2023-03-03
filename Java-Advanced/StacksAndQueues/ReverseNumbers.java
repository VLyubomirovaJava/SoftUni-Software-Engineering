package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
// 1. 1.create an [] to store numbers from console
        // 2.create stack
        // 3.iterate through numbers to add them to stack
        // 4.create a while cycle during which we push() numbers till stack is empty
        // 5.print numbers
        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String number : numbers) {
            stack.push(Integer.valueOf(number));
        }
        while (!stack.isEmpty()) {
            System.out.printf("%s ", stack.pop());
        }
    }
}
