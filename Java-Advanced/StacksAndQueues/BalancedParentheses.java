package StacksAndQueues;

import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {

        //{[()]} - This is a balanced parenthesis.
        //{[(])} - This is not a balanced parenthesis.

        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        boolean isBalanced = true;
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openingBrackets.push(currentBracket);
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningBracket = openingBrackets.pop();
                if (currentBracket == '}' && lastOpeningBracket != '{') { // no balance
                    isBalanced = false;
                    break;
                } else if (currentBracket == ')' && lastOpeningBracket != '(') { // no balance
                    isBalanced = false;
                    break;
                } else if (currentBracket == ']' && lastOpeningBracket != '[') { // no balance
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced && openingBrackets.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");

        }
    }
}