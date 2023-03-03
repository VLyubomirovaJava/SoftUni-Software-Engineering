package StacksAndQueues;

import java.util.*;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
int decimal =Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
// Divide the number by 2 and store the remainders in the stack
        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        // Print 0 if the stack is empty (decimal was 0)
        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        // Pop all the remainders from the stack and print them
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}

//Here is a breakdown of the steps:
//
//    Read the decimal number from the console using a Scanner .
//    Create a stack to store the remainders.
//    Divide the decimal number by 2 and store the remainder in the stack. Update the value of the decimal number to be the result of the division.
//    Repeat step 3 until the decimal number is 0.
//    If the stack is empty (which means the original decimal number was 0), print 0 and return.
//    Pop all the remainders from the stack and print them.
//
//This solution works by using the stack to store the remainders from the divisions in reverse order, so that when they are popped from the stack, they are in the correct order for the binary representation.
