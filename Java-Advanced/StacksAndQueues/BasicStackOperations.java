package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 1. string [] to contain checkNumbers
        // 2. for cycle to push numb
        // 3. for cycle to pop num
        //4. if we find num - > print true, if not -> print min num
        // if stack is empty -> print 0
        //include those in a series of if checks

        String[] checkNumbers = scanner.nextLine().split("\\s+");
        int numToPush = Integer.parseInt(checkNumbers[0]);
        int numToPop = Integer.parseInt(checkNumbers[1]);
        int numToCheck = Integer.parseInt(checkNumbers[2]);

        String[] numbersForStack = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < numToPush; i++) {
            stack.push(Integer.parseInt(numbersForStack[i]));
        }
        for (int i = 0; i < numToPop; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(numToCheck)) {
            System.out.println("true");
        } else {
            int minNum = Collections.min(stack);  // collections method to find min num in the stack
            System.out.println(minNum);
        }
    }
}
