package StacksAndQueues;

import java.util.*;

public class SimpleCalculator {
    // 1. record the input as an string [], divided by space,
    // so that we can get the numbers and operators as separated values

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
String[] tokens =scanner.nextLine().split("\\s+");
Deque<String> stack = new ArrayDeque<>();
    Collections.addAll(stack,tokens);
    while (stack.size()>1){
        int firstNum = Integer.parseInt(stack.pop());
        String operator = stack.pop();
        int secondNum = Integer.parseInt(stack.pop());
        if (operator.equals("+")){
            stack.push(String.valueOf(firstNum+secondNum));
        } else {
            stack.push(String.valueOf(firstNum-secondNum));
        }

    }
        System.out.println(stack.pop());
    }
} 
