package MultidimentionalArrays;

import java.util.*;

public class FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[n][n];
        if (pattern.equals("A")) {
            ifPatternIsA(n, matrix);

        } else if (pattern.equals("B")) {
            ifPatternIsB(n, matrix);
        }
        printMatrix(n, matrix);

    }

    private static void ifPatternIsB(int n, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                //increasing order
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                //decreasing order
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }


    private static void ifPatternIsA(int size, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }


    private static void printMatrix(int n, int[][] matrix) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
