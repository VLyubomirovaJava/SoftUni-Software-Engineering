package MultidimentionalArrays;

import java.util.*;


public class MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char outside = (char) ('a' + row);
                char middle = (char) (outside + col);
                matrix[row][col] = String.valueOf(outside) + middle + outside;
            }
        }
        printMatrix(rows, cols, matrix);

    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}