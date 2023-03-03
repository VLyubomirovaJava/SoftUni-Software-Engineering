package ExamPreparation;

import java.util.*;

public class Python {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] matrix = new char[n][n];
//filling matrix
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        //find the python
        //fild all food
        int countFood = 0;
        int rowPython = 0;
        int colPython = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 's') {
                    rowPython = row;
                    colPython = col;
                } else if (currentElement == 'f') {
                    countFood++;
                }
            }
        }
        //moves
        int length = 1;  //python's length
        boolean isDead = false;
        for (String command : commands) {
            matrix[rowPython][colPython] = '*';
            switch (command) {
                case "left":
                    colPython--;

                    break;

                case "right":
                    colPython++;

                    break;

                case "up":
                    rowPython--;

                    break;
                case "down":
                    rowPython++;

                    break;
            }
            if (rowPython < 0 || rowPython >= n) {
                if (rowPython < 0) {
                    rowPython = n - 1; //python goes to final row when coming out from the upper side

                }
                if (rowPython >= n) {
                    rowPython = 0;
                }
            }
            if (colPython < 0 || colPython >= n) {
                if (colPython < 0) {
                    colPython = n - 1;
                }
                if (colPython >= n) {
                    colPython = 0;
                }
            }
            if (countFood == 0) {
                System.out.println("You win! Final python length is " + length);
                break;
            }
            // where did we go?
            if (matrix[rowPython][colPython] == 'f') {
                length++;
                countFood--;

            }
            if (matrix[rowPython][colPython] == 'e') {
                isDead = true;
                break;
            }
            matrix[rowPython][colPython] = 's';
        }
        //if python is still alive or there's still food left
        if (countFood == 0) {
            System.out.println("You win! Final python length is " + length);


        } else if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }

    }
}