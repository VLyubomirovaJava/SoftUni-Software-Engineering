package StackOfStrings;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stack = new StackOfStrings(new ArrayList<>());
        stack.push("one");
        stack.push("two");
        stack.push("three");
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
