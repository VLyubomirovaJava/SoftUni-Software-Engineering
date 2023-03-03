package MultidimentionalArrays;

import java.util.Scanner;

public class StringMatrixRotation2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int degree = Integer.parseInt(command.substring(7, command.length() - 1));
        // This is done so that we only need to handle four cases
        // (rotations of 0, 90, 180, and 270 degrees) instead of an arbitrary number of degrees.

        degree %= 360; // only care about the remainder when rotating by 360 degrees
        if (degree < 0) {
            degree += 360;
        }
        String[] matrix = new String[1000];
        int matrixSize = 0;
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            matrix[matrixSize++] = line;
            line = scanner.nextLine();
        }
        //The code enters a loop that iterates through the matrix, and for each line,
        // updates "maxLength" to be the maximum length of all the lines in the matrix.

        int maxLength = 0;
        for (int i = 0; i < matrixSize; i++) {
            maxLength = Math.max(maxLength, matrix[i].length());
        }
        //If the degree is 90, the code iterates through the matrix column by column (starting with the rightmost column), and prints out each character in the column (from top to bottom).
        // If a column is shorter than the longest column,
        // spaces are printed to pad the matrix.

        if (degree == 90) {
            for (int i = 0; i < maxLength; i++) {
                for (int j = matrixSize - 1; j >= 0; j--) {
                    if (i < matrix[j].length()) {
                        System.out.print(matrix[j].charAt(i));
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            //If the degree is 180, the code iterates through the matrix from bottom to top,
            // and for each line, prints out each character in the line in reverse order.
        } else if (degree == 180) {
            for (int i = matrixSize - 1; i >= 0; i--) {
                for (int j = matrix[i].length() - 1; j >= 0; j--) {
                    System.out.print(matrix[i].charAt(j));
                }
                System.out.println();
            }
            //If the degree is 270, the code iterates through the matrix column by column
            // (starting with the leftmost column),
            // and prints out each character in the column (from bottom to top).
            // If a column is shorter than the longest column,
            // spaces are printed to pad the matrix.

        } else if (degree == 270) {
            for (int i = maxLength - 1; i >= 0; i--) {
                for (int j = 0; j < matrixSize; j++) {
                    if (i < matrix[j].length()) {
                        System.out.print(matrix[j].charAt(i));
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            // degree == 0
            //If the degree is 0 (or any other value that is not 90, 180, or 270),
            // the code simply prints out the matrix as it is, without any rotation.

            for (int i = 0; i < matrixSize; i++) {
                System.out.println(matrix[i]);
            }
        }
    }
}